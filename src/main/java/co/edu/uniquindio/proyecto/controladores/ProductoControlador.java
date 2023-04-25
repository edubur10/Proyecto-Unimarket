package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoControlador {
    private final ProductoServicio productoServicio;

    @PostMapping("/crear")
    int crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception{
        return productoServicio.crearProducto(productoDTO);
    }

    @PutMapping("/actualizarProductos/{codigo}")
    int actualizarProducto(@PathVariable int codigoProducto, @RequestBody ProductoGetDTO productoGetDTO) throws Exception{
        return productoServicio.actualizarProducto(codigoProducto,productoGetDTO);
    }

    @PutMapping("/actualizarUnidades/{codigo}")
    int actualizarUnidades(@PathVariable int codigoProducto,@PathVariable int unidades) throws Exception{
        return productoServicio.actualizarUnidades(codigoProducto,unidades);
    }

    @GetMapping("/obtenerProducto/{codigo}")
    ProductoGetDTO obtenerProducto(@PathVariable int codigoProducto) throws Exception{
        return productoServicio.obtenerProducto(codigoProducto);
    }


}