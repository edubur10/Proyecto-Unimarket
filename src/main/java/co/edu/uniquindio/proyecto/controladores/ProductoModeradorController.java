package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoModeradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ProductoModeradorController {
    private final ProductoModeradorService productoModeradorService;

    public ProductoModeradorController(ProductoModeradorService productoModeradorService) {
        this.productoModeradorService = productoModeradorService;
    }

    @GetMapping("/moderador/{moderadorId}")
    public List<ProductoGetDTO> listarProductosPorModerador(@PathVariable Integer moderadorId) {
        ModeradorGetDTO moderadorDTO = new ModeradorGetDTO();
        moderadorDTO.setCodigo(moderadorId);

        return productoModeradorService.listarProductosPorModerador(moderadorDTO);
    }
}
