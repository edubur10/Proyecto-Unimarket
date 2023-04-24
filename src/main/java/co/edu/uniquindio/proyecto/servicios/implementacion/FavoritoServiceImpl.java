package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.FavoritoDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Favorito;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.FavoritoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FavoritoServiceImpl implements FavoritoService {
    @Autowired
    private FavoritoRepo favoritoRepo;

    @Override
    public List<FavoritoDTO> listarFavoritosPorUser(int codigoUser) {
        List<Favorito> favoritos = favoritoRepo.listarFavoritosPorUser(codigoUser);
        List<FavoritoDTO> favoritosDTO = new ArrayList<>();

        for (Favorito favorito : favoritos) {
            favoritosDTO.add(new FavoritoDTO(
                    favorito.getProducto().getCodigo(),
                    favorito.getProducto().getNombre(),
                    favorito.getProducto().getDescripcion(),
                    favorito.getProducto().getUsuario().getCodigo()
            ));
        }

        return favoritosDTO;
    }

    @Override
    public FavoritoDTO listarFavoritosPorProductAndUser(Producto producto, Usuario usuario) {
        Optional<Favorito> favorito = favoritoRepo.listarFavoritosPorProductAndUser(producto, usuario);

        if (favorito.isPresent()) {
            Favorito f = favorito.get();
            return new FavoritoDTO(
                    f.getProducto().getCodigo(),
                    f.getProducto().getNombre(),
                    f.getProducto().getDescripcion(),
                    f.getProducto().getUsuario().getCodigo()
            );
        }

        return null;
    }
}
