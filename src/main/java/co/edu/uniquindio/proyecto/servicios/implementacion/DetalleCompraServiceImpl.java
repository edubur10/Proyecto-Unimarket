package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Compra;
import co.edu.uniquindio.proyecto.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.DetalleCompraService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DetalleCompraServiceImpl implements DetalleCompraService {
    private final DetalleCompraRepo detalleCompraRepo;

    @Override
    public List<DetalleCompraDTO> listarPorCodigoProducto(Integer codigo) {
        List<DetalleCompra> detallesCompra = detalleCompraRepo.listarPorCodigoProducto(codigo);
        return detallesCompra.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DetalleCompraDTO> listarPorCompra(CompraGetDTO compraDTO) {
        Compra compra = toEntity(compraDTO);
        List<DetalleCompra> detallesCompra = detalleCompraRepo.listarPorCompra(compra);
        return detallesCompra.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private DetalleCompraDTO toDTO(DetalleCompra detalleCompra) {

        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();
        detalleCompraDTO.setCodigo(detalleCompra.getCodigo());
        detalleCompraDTO.setUnidades(detalleCompra.getUnidades());
        detalleCompraDTO.setPrecio(detalleCompra.getPrecio_producto());

        ProductoGetDTO productoGetDTO = new ProductoGetDTO();
        productoGetDTO.setCodigo(detalleCompra.getProducto().getCodigo());
        productoGetDTO.setEstado(detalleCompra.getProducto().getEstado());
        productoGetDTO.setFechaLimite(detalleCompra.getProducto().getFechaLimite());
        productoGetDTO.setNombre(detalleCompra.getProducto().getNombre());
        productoGetDTO.setDescripcion(detalleCompra.getProducto().getDescripcion());
        productoGetDTO.setUnidades(detalleCompra.getProducto().getUnidades());
        productoGetDTO.setPrecio(detalleCompra.getProducto().getPrecio());
        productoGetDTO.setImagenes(detalleCompra.getProducto().getImagenes());
        productoGetDTO.setCategorias(detalleCompra.getProducto().getCategorias());

        return detalleCompraDTO;
    }

    private Compra toEntity(CompraGetDTO compraDTO) {
        Compra compra = new Compra();
        compra.setCodigo(compraDTO.getCodigo());
        // mapear otras propiedades de CompraGetDTO a Compra si es necesario
        return compra;
    }
}
