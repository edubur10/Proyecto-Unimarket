package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentario")
@AllArgsConstructor
public class ComentarioControlador {

    private final ComentarioServicio comentarioServicio;

    /*
@GetMapping("/obtener/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(@PathVariable int codigoUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, usuarioServicio.obtenerUsuario(codigoUsuario)));
    }
*/
    @PostMapping("/crear")
    ResponseEntity<MensajeDTO> crearComentario(@RequestBody ComentarioDTO comentarioDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, comentarioServicio.crearComentario(comentarioDTO)));
    }

    @PutMapping("/actualizar/{codigo}")
    ResponseEntity<MensajeDTO> actualizarComentario(@PathVariable int codigoProducto, @RequestBody ComentarioDTO comentarioDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, comentarioServicio.actualizarComentario(codigoProducto,comentarioDTO)));
    }


    @DeleteMapping("/eliminar/{codigo}")
    ResponseEntity<MensajeDTO> eliminarComentario(@PathVariable int codigoComentario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, comentarioServicio.eliminiarComentario(codigoComentario)));
    }


    @GetMapping("/obtener/{codigo}")
    ResponseEntity<MensajeDTO> obtenerComentario(@PathVariable int codidoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, comentarioServicio.obtenerComentario(codidoProducto)));
    }

    @GetMapping("/comentarios/{codigoProducto}")
    ResponseEntity<MensajeDTO<List<ComentarioGetDTO>>> listarComentarios(@PathVariable int codigoProducto) {
        List<ComentarioGetDTO> comentarios = comentarioServicio.listarComentarios(codigoProducto);
        MensajeDTO<List<ComentarioGetDTO>> mensaje = new MensajeDTO<>(HttpStatus.OK, false, comentarios);
        return ResponseEntity.ok(mensaje);
    }
}