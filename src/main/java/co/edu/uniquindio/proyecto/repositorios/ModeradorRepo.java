package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Moderador;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {
    @Query("SELECT pm.producto FROM ProductoModerador pm WHERE pm.moderador.codigo = :moderadorId")
    List<Producto> ListarPorModeradorId(Integer moderadorId);

}
