package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.entidades.MetodoPago;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
public class CompraTest {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private CompraServicio compraServicio;

    private CompraRepo compraRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCompraTest() throws Exception {

        List<String> telefonos = new ArrayList<>();
        telefonos.add("3225247458");
        telefonos.add("3225874152");
        //Primero debemos crear el usuario
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                telefonos);
        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        //Validamos que el usuario se cree correctamente
        Assertions.assertNotEquals(0, codigo);

        //Creamos el detalle producto en este caso es null pero no deberia
        List<DetalleCompra> lista = new ArrayList<>();
        lista.add(new DetalleCompra()) ;

        //Creamos la compra DTO
        CompraDTO compraDTO = new CompraDTO(
                codigo,
                12000,
                "juege",
                lista);
        //Llamamos el metodo crar compra
        int codigoCompra = compraServicio.crearCompra(compraDTO);

        //validamos si se creo
        Assertions.assertNotEquals(0, codigoCompra);
    }



    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCompraTest() throws Exception {

        //Primero debemos crear el usuario
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                "343");
        int codigoUsuario = usuarioServicio.crearUsuario(usuarioDTO);

        //Validamos que el usuario se cree correctamente
        Assertions.assertNotEquals(0, codigoUsuario);

        //Creamos el detalle producto en este caso es null pero no deberia
        List<DetalleCompra> lista = new ArrayList<>();
        lista.add(new DetalleCompra()) ;

        //Creamos la lista de cupones en este caso es null pero no deberia
        List<Cupon> listaCupon = new ArrayList<>();
        listaCupon.add(new Cupon());

        //Creamos la compra DTO
        CompraDTO compraDTO = new CompraDTO(
                codigoUsuario,
                12000,
                "juege",
                lista,
                listaCupon);
        //Llamamos el metodo crar compra
        int codigoCompra = compraServicio.crearCompra(compraDTO);

        //validamos si se creo
        Assertions.assertNotEquals(0, codigoCompra);

        CompraGetDTO compraGetDTOActualizar = compraServicio.actualizarCompra( codigoCompra,new CompraDTO(
                codigoUsuario,
                13000,
                "juege",
                lista,
                listaCupon));
        //Llamamos el metodo crar compra
        //   int codigoCompra = compraServicio.crearCompra(compraDTO);

        //validamos si se creo
        Assertions.assertNotEquals(12000, compraGetDTOActualizar.getValorTotal());


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  eliminiarCompraTest() throws Exception {
        //Primero debemos crear el usuario
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                "343");
        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        //Validamos que el usuario se cree correctamente
        Assertions.assertNotEquals(0, codigo);

        //Creamos el detalle producto en este caso es null pero no deberia
        List<DetalleCompra> lista = new ArrayList<>();
        lista.add(new DetalleCompra()) ;

        //Creamos la lista de cupones en este caso es null pero no deberia
        List<Cupon> listaCupon = new ArrayList<>();
        listaCupon.add(new Cupon());

        //Creamos la compra DTO
        CompraDTO compraDTO = new CompraDTO(
                codigo,
                12000,
                "juege",
                lista,
                listaCupon);
        //Llamamos el metodo crar compra
        int codigoCompra = compraServicio.crearCompra(compraDTO);

        //validamos si se creo
        Assertions.assertNotEquals(0, codigoCompra);

        //Una vez creado, lo borramos
        int codigoBorrado = compraServicio.eliminiarCompra(codigoCompra);

        Assertions.assertEquals(codigoBorrado,codigoCompra);


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  obtenerCompraTest() throws Exception {
        //Primero debemos crear el usuario
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                "343");
        int codigo = usuarioServicio.crearUsuario(usuarioDTO);

        //Validamos que el usuario se cree correctamente
        Assertions.assertNotEquals(0, codigo);

        //Creamos el detalle producto en este caso es null pero no deberia
        List<DetalleCompra> lista = new ArrayList<>();
        lista.add(new DetalleCompra()) ;

        //Creamos la lista de cupones en este caso es null pero no deberia
        List<Cupon> listaCupon = new ArrayList<>();
        listaCupon.add(new Cupon());

        //Creamos la compra DTO
        CompraDTO compraDTO = new CompraDTO(
                codigo,
                12000,
                "juege",
                lista,
                listaCupon);
        //Llamamos el metodo crar compra
        int codigoCompra = compraServicio.crearCompra(compraDTO);

        //validamos si se creo
        Assertions.assertNotEquals(0, codigoCompra);

        //Una vez creado, lo borramos
        Compra obtenerCompra = compraServicio.obtenerCompra(codigoCompra);

        Assertions.assertEquals(obtenerCompra.getCodigo(),codigoCompra);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComprasTest() throws Exception {

    }

}
