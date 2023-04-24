package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.exceptions.RecursoNoEncontradoException;
import co.edu.uniquindio.proyecto.modelo.entidades.Compra;
import co.edu.uniquindio.proyecto.servicios.implementacion.DetalleCompraServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class DetalleCompraController {
    private final DetalleCompraServiceImpl detalleCompraService;

    public DetalleCompraController(DetalleCompraServiceImpl detalleCompraService) {
        this.detalleCompraService = detalleCompraService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> listarPorCodigoProducto(@PathVariable("codigo") Integer codigo) {
        try {
            List<DetalleCompraDTO> detalleCompraDTOs = detalleCompraService.listarPorCodigoProducto(codigo);
            return new ResponseEntity<>(detalleCompraDTOs, HttpStatus.OK);
        } catch (RecursoNoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/compras/{codigo}")
    public ResponseEntity<?> listarPorCompra(@PathVariable("codigo") CompraGetDTO compra) {
        try {
            List<DetalleCompraDTO> detalleCompraDTOs = detalleCompraService.listarPorCompra(compra);
            return new ResponseEntity<>(detalleCompraDTOs, HttpStatus.OK);
        } catch (RecursoNoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
