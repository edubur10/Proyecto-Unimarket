package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Categoria;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class ProductoTest {

    @Autowired
    private ProductoRepo miProductoRepo;
    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrarProducto()throws Exception{

        List<String> telefonos = new ArrayList<>();
        telefonos.add("3225247458");
        telefonos.add("3225874152");

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                telefonos);

        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigoVendedor = usuarioServicio.crearUsuario(usuarioDTO);

        //Se crea la colección de imágenes para el producto.
        List<String> imagenes = new ArrayList<>();
        imagenes.add("http://www.google.com/images/imagenasus.png");
        imagenes.add("http://www.google.com/images/imagenasus_original.png");

        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
        ProductoDTO productoDTO = new ProductoDTO(
                "Computador Asus 1",
                "Es el mejor computador portatil que el dinero pueda comprar",
                1,
                7000000,
                codigoVendedor,
                imagenes,
                List.of(Categoria.TECNOLOGIA)
        );

        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto( productoDTO );

        //Se espera que el servicio retorne el código del nuevo producto
        Assertions.assertNotEquals(0, codigoProducto);

    }

    @Test
    public void listarProductosTestSql(){

        //se guardan los datos del sql en una lista
        List<ProductoGetDTO> listaProductos=productoServicio.listarProductosNombre("Computador Asus 1");

        //el for se usa para mostrar los datos guardados en la lista
        for (ProductoGetDTO misProductos: listaProductos) {
            System.out.println(misProductos);
        }
    }

    @Test
    public void actualizarUsuarioTest() throws Exception {
        ProductoGetDTO producto = productoServicio.obtenerProducto(1);
        producto.setPrecio(7522114);

        productoServicio.actualizarProducto(1, producto);

        ProductoGetDTO producto1 = productoServicio.obtenerProducto(1);

        Assertions.assertEquals(7522114, producto1.getPrecio());

    }

    @Test
    public void eliminarProductoTest()throws Exception{
        try{

            productoServicio.eliminarProducto(2);
            ProductoGetDTO eliminado = productoServicio.obtenerProducto(2);
            Assertions.assertNull(eliminado);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
