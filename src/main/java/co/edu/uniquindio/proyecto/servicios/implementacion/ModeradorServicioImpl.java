package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.modelo.entidades.Moderador;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {

    @Autowired
    ModeradorRepo moderadorRepo;
    @Autowired
    private ProductoServicio productoServicio;
    @Override
    public void aprobarProducto(int codigoProducto) throws Exception {

        Producto producto = productoServicio.obtener(codigoProducto);
        if (producto!= null){
            if (!producto.getEstado().equals("APROBADO")){
                producto.setEstado(producto.getEstado());
            }else {
                throw new Exception("El producto ya esta aprovado");
            }

        }else {
            throw new Exception("producto en el codigo: "+ codigoProducto+ "No se a encontrado");
        }

    }

    @Override
    public void rechazarProducto(int codigoProducto) throws Exception {

        Producto producto = productoServicio.obtener(codigoProducto);
        if (producto!= null){
            if (!producto.getEstado().equals("INACTIVO")){
                producto.setEstado(producto.getEstado()); //Preguntar
            }else {
                throw new Exception("El producto esta Rechazado");
            }

        }else {
            throw new Exception("producto en el codigo: "+ codigoProducto+ "No se a encontrado");
        }
    }

    @Override
    public Moderador obtenerModerador(int codigoModerador) throws Exception {
        Optional<Moderador> moderador = moderadorRepo.findById(codigoModerador);

        if(moderador.isEmpty() ) {
            throw new Exception("El código " + codigoModerador + " no está asociado a ningún usuario");
        }
        return moderador.get();
    }
}
