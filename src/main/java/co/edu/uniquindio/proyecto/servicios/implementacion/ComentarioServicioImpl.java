package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Comentario;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ProductoServicio productoServicio;
    private final UsuarioServicio usuarioServicio;
    private final ComentarioRepo comentarioRepo;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {

        Comentario comentario = convertirDTOaComentario(comentarioDTO);
        Comentario comentarioGuardado = comentarioRepo.save(comentario);

        // Envío del correo electrónico
        String destinatario = comentario.getUsuario().getEmail();
        String asunto = "Nuevo comentario en Unimarket";
        String mensaje = "Has publicado un nuevo comentario en Unimarket.";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(destinatario);
        email.setSubject(asunto);
        email.setText(mensaje);
        javaMailSender.send(email);

        return comentarioGuardado.getCodigo();
    }

    private Comentario convertirDTOaComentario(ComentarioDTO comentarioDTO) throws Exception {

        Usuario usuario = usuarioServicio.obtener(comentarioDTO.getCodigoUsuario());
        Producto producto = productoServicio.obtener(comentarioDTO.getCodigoProducto());

        if (usuario == null){
            throw new Exception("El código "+usuario.getCodigo()+" no está asociado a ningún usuario");
        }
        if (producto == null){
            throw new Exception("El código "+producto.getCodigo()+" no está asociado a ningún producto");
        }
        Comentario comentario = new Comentario();
        comentario.setProducto(producto);
        comentario.setUsuario(usuario);
        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setFecha(comentarioDTO.getLocalDateTime());

        return comentario;
    }

    @Override
    public ComentarioGetDTO actualizarComentario(int codigoComentario, ComentarioDTO comentarioDTO) throws Exception {
        validarExiste(codigoComentario);

        Comentario comentario = convertirDTOaComentario(comentarioDTO);
        comentario.setCodigo(codigoComentario);

        return convertirComentarioaGetDTO( comentarioRepo.save(comentario) );
    }

    private ComentarioGetDTO convertirComentarioaGetDTO(Comentario comentario) throws Exception {



        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(

                comentario.getCodigo(),
                comentario.getFecha(),
                comentario.getMensaje(),
                comentario.getUsuario().getCodigo(),
                comentario.getProducto().getCodigo());


        return  comentarioGetDTO;
    }

    @Override
    public int eliminiarComentario(int codigoComentario) throws Exception {

        validarExiste(codigoComentario);
        comentarioRepo.deleteById(codigoComentario);
        return codigoComentario;

    }

    private void validarExiste(int codigoComentario) throws Exception {

        boolean existe = comentarioRepo.existsById(codigoComentario);

        if( !existe ){
            throw new Exception("El código "+codigoComentario+" no está asociado a ningún usuario");
        }
    }

    @Override
    public ComentarioGetDTO obtenerComentario(int codigoComentario) throws Exception {
        return convertirGetDTOaComentario( obtener(codigoComentario) );
    }

    private ComentarioGetDTO convertirGetDTOaComentario(Comentario comentario) {
        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getCodigo(),
                comentario.getFecha(),
                comentario.getMensaje(),
                comentario.getUsuario().getCodigo(),
                comentario.getProducto().getCodigo());

        return comentarioGetDTO;
    }

    @Override
    public Comentario obtener(int codigoComentario) throws Exception {
        Optional<Comentario> comentario = comentarioRepo.findById(codigoComentario);

        if(comentario.isEmpty() ){
            throw new Exception("El código "+codigoComentario+" no está asociado a ningún comentario");
        }

        return comentario.get();
    }

    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto) {

        List<Comentario> lista = comentarioRepo.listarComentarios(codigoProducto);
        List<ComentarioGetDTO> respuesta = new ArrayList<>();

        for (Comentario comentario : lista) {
            respuesta.add(convertirGetDTOaComentario(comentario));
        }

        return respuesta;
    }

}