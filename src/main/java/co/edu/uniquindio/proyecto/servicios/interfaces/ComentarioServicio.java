package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Comentario;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    List<ComentarioGetDTO> listarComentarios(int codigoProducto);

    Comentario obtener(int codigo) throws Exception;

    ComentarioGetDTO convertir(Comentario comentario) throws Exception;

    ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception;

}
