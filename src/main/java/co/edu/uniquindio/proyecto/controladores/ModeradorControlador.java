package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/moderador")
@AllArgsConstructor
public class ModeradorControlador {

    private final ModeradorServicio moderadorServicio;

    @PutMapping("/aprovar/{codigo}")
    void aprobarProducto(@RequestBody Producto codigoProducto) throws Exception{

    }

    @PutMapping("/rechazar/{codigo}")
    void rechazarProducto(@RequestBody  Producto codigoProducto) throws Exception{

    }

}