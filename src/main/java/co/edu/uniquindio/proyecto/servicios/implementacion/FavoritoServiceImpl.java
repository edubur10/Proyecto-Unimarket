package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.exceptions.NotFoundException;
import co.edu.uniquindio.proyecto.modelo.entidades.Favorito;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.FavoritoRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.FavoritoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FavoritoServiceImpl implements FavoritoService {
    @Autowired
    private FavoritoRepo favoritoRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public List<FavoritoDTO> listarFavoritosPorUser(UsuarioGetDTO usuarioDTO) {
        Usuario usuario = usuarioRepo.findById(usuarioDTO.getCodigo())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        List<Favorito> favoritos = favoritoRepo.listarFavoritosPorUser(usuario.getCodigo());
        return favoritos.stream().map(favorito -> new FavoritoDTO(
                new ProductoGetDTO(
                        favorito.getProducto().getCodigo(),
                        favorito.getProducto().getEstado(),
                        favorito.getProducto().getFechaLimite(),
                        favorito.getProducto().getNombre(),
                        favorito.getProducto().getDescripcion(),
                        favorito.getProducto().getUnidades(),
                        favorito.getProducto().getUsuario().getCodigo(),
                        favorito.getProducto().getPrecio(),
                        favorito.getProducto().getImagenes(),
                        favorito.getProducto().getCategorias()
                ),
                new UsuarioGetDTO(
                        favorito.getUsuario().getCodigo(),
                        favorito.getUsuario().getNombre(),
                        favorito.getUsuario().getEmail(),
                        favorito.getUsuario().getDireccion(),
                        favorito.getUsuario().getTelefono()
                )
        )).collect(Collectors.toList());
    }

    @Override
    public FavoritoDTO listarFavoritosPorProductAndUser(ProductoGetDTO productoDTO, UsuarioGetDTO usuarioDTO) {
        Producto producto = productoRepo.findById(productoDTO.getCodigo())
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        Usuario usuario = usuarioRepo.findById(usuarioDTO.getCodigo())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        Favorito favorito = favoritoRepo.listarFavoritosPorProductAndUser(producto, usuario)
                .orElseThrow(() -> new NotFoundException("Favorito no encontrado"));

        return new FavoritoDTO(
                new ProductoGetDTO(
                        favorito.getProducto().getCodigo(),
                        favorito.getProducto().getEstado(),
                        favorito.getProducto().getFechaLimite(),
                        favorito.getProducto().getNombre(),
                        favorito.getProducto().getDescripcion(),
                        favorito.getProducto().getUnidades(),
                        favorito.getProducto().getUsuario().getCodigo(),
                        favorito.getProducto().getPrecio(),
                        favorito.getProducto().getImagenes(),
                        favorito.getProducto().getCategorias()
                ),
                new UsuarioGetDTO(
                        favorito.getUsuario().getCodigo(),
                        favorito.getUsuario().getNombre(),
                        favorito.getUsuario().getEmail(),
                        favorito.getUsuario().getDireccion(),
                        favorito.getUsuario().getTelefono()
                )
        );

    }
    @Override
    public void agregarFavorito(FavoritoDTO favoritoDTO) {
        Favorito favorito = new Favorito();
        favorito.setUsuario(usuarioRepo.findById(favoritoDTO.getUsuario().getCodigo()).orElseThrow(() -> new NotFoundException("Usuario no encontrado")));
        favorito.setProducto(productoRepo.findById(favoritoDTO.getProducto().getCodigo()).orElseThrow(() -> new NotFoundException("Producto no encontrado")));
        favoritoRepo.save(favorito);
    }

    @Override
    public void eliminarFavorito(FavoritoGetDTO favoritoDTO) {
        Favorito favorito = favoritoRepo.findById(favoritoDTO.getCodigo()).orElseThrow(() -> new NotFoundException("Favorito no encontrado"));
        favoritoRepo.delete(favorito);
    }
}
