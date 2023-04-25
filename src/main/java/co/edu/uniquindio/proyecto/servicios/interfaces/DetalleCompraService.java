package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Compra;
import co.edu.uniquindio.proyecto.modelo.entidades.DetalleCompra;

import java.util.List;

public interface DetalleCompraService {
    List<DetalleCompraDTO> listarPorCodigoProducto(Integer codigo);
    List<DetalleCompraDTO> listarPorCompra(CompraGetDTO compraDTO);

    List<Integer> obtenerDetallesCodigo(List<DetalleCompra> compras);

    DetalleCompraGetDTO obtenerDetalleCompra(int codigoDetalleCompra) throws Exception;
}
