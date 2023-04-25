package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.FavoritoDTO;
import co.edu.uniquindio.proyecto.dto.FavoritoGetDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.exceptions.NotFoundException;
import co.edu.uniquindio.proyecto.modelo.entidades.Favorito;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.FavoritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {
    private final FavoritoService favoritoService;

    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<FavoritoDTO> listarFavoritosPorUsuario(@PathVariable Integer usuarioId) {
        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO();
        usuarioDTO.setCodigo(usuarioId);

        List<FavoritoDTO> favoritosDTO = favoritoService.listarFavoritosPorUser(usuarioDTO);

        return favoritosDTO;
    }

    @PostMapping("/favoritos")
    public ResponseEntity<String> agregarFavorito(@RequestBody FavoritoDTO favoritoDto) {
        try {
            favoritoService.agregarFavorito(favoritoDto);
            return ResponseEntity.ok("Favorito agregado correctamente");
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/favoritos")
    public ResponseEntity<Void> eliminarFavorito(@RequestBody FavoritoGetDTO favoritoDTO) {
        favoritoService.eliminarFavorito(favoritoDTO);
        return ResponseEntity.noContent().build();
    }
}
