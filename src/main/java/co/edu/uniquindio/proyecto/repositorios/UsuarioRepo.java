package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository <Usuario, Integer> {//Java persistence appi --> las consultas funcionen sin problemas

    @Query("select u from Usuario u where u.email = : correo")
    Usuario buscarUsuario(String correo);
}
