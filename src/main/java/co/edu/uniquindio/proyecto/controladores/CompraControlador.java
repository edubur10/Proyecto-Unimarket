package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Compra;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/compra")
@AllArgsConstructor
public class CompraControlador {

    private final CompraServicio compraServicio;


    @PostMapping("/crear")
    int crearCompra(@RequestBody CompraDTO compraDTO) throws Exception{
        return compraServicio.crearCompra(compraDTO);
    }


    @GetMapping("/obtener/{codigo}")
    Compra obtenerCompra(@PathVariable int codigoCompra) throws Exception{
        return compraServicio.obtener(codigoCompra);
    }
}
