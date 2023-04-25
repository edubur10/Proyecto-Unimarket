package co.edu.uniquindio.proyecto.mappers;

import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductoMapper {
    public static ProductoGetDTO toDto(Producto producto) {
        ProductoGetDTO productoGetDTO = new ProductoGetDTO();
        productoGetDTO.setCodigo(producto.getCodigo());
        productoGetDTO.setEstado(producto.getEstado());
        productoGetDTO.setFechaLimite(producto.getFechaLimite());
        productoGetDTO.setNombre(producto.getNombre());
        productoGetDTO.setDescripcion(producto.getDescripcion());
        productoGetDTO.setUnidades(producto.getUnidades());
        productoGetDTO.setPrecio(producto.getPrecio());
        productoGetDTO.setImagenes(producto.getImagenes());
        productoGetDTO.setCategorias(producto.getCategorias());
        return productoGetDTO;

    }
    public Producto toEntity(ProductoGetDTO productoGetDTO) {
        Producto producto = new Producto();
        producto.setCodigo(productoGetDTO.getCodigo());
        producto.setEstado(productoGetDTO.getEstado());
        producto.setFechaLimite(productoGetDTO.getFechaLimite());
        producto.setNombre(productoGetDTO.getNombre());
        producto.setDescripcion(productoGetDTO.getDescripcion());
        producto.setUnidades(productoGetDTO.getUnidades());
        producto.setPrecio(productoGetDTO.getPrecio());
        producto.setImagenes(productoGetDTO.getImagenes());
        producto.setCategorias(productoGetDTO.getCategorias());
        return producto;
    }

    public static List<ProductoGetDTO> mapToDtoList(List<Producto> productos) {
        return productos.stream()
                .map(ProductoMapper::toDto)
                .collect(Collectors.toList());
    }
}
