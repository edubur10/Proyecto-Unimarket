package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.FavoritoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;

import java.util.List;

public interface FavoritoService {
    List<FavoritoDTO> listarFavoritosPorUser(UsuarioDTO usuario);
    FavoritoDTO listarFavoritosPorProductAndUser(Producto producto, Usuario usuario);

}
