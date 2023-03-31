package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Estado;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.usuario.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) and p.estado = co.edu.uniquindio.proyecto.modelo.entidades.Estado.APROBADO")
    List<Producto> listarProductosNombre(String nombre);


    @Query("select p from Producto p where p.estado = :estado and p.estado = co.edu.uniquindio.proyecto.modelo.entidades.Estado.APROBADO")
    List<Producto> listarProductosPorEstado(Estado estado);


}
