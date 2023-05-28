package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import org.springframework.stereotype.Repository;

public interface EmailRepo {

    @Repository
    public interface EmailRepository {
        void enviarEmail(EmailDTO emailDTO);
    }

}
