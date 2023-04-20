package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception
    {
        Comentario comentario = new Comentario();

        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setUsuario( usuarioServicio.obtener( comentarioDTO.getCodigoUsuario()) );
        comentario.setProducto(productoServicio.obtener(comentarioDTO.getCodigoProducto()));

        return comentarioRepo.save( comentario ).getCodigo();
    }


    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto)
    {
        List<Comentario> lista = comentarioRepo.listarComentarios(codigoProducto);
        List<ComentarioGetDTO> respuesta = new ArrayList<>();

        for(Comentario c : lista )
        {
            respuesta.add( convertir(c) );
        }
        return respuesta;
    }

    public ComentarioGetDTO convertir(Comentario comentario)
    {

        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getCodigo(),
                comentario.getFecha(),
                comentario.getMensaje(),
                comentario.getUsuario().getCodigo(),
                comentario.getProducto().getCodigo()
        );


        return comentarioGetDTO;
    }


    private void validarExiste(int codigoComentario) throws Exception
    {
        boolean existe = comentarioRepo.existsById(codigoComentario);

        if( !existe )
        {
            throw new Exception("El código "+codigoComentario+" no está asociado a ningún comentario");
        }

    }

    public Comentario obtener(int codigoComentario) throws Exception
    {
        Optional<Comentario> comentario = comentarioRepo.findById(codigoComentario);

        if(comentario.isEmpty() )
        {

            throw new Exception("El código "+codigoComentario+" no está asociado a ninguna calificacion");
        }

        return comentario.get();
    }


    public ComentarioGetDTO obtenerComentario(int codigoComentario)  throws Exception
    {
        return convertir( obtener(codigoComentario) );
    }
}