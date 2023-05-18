package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Categoria;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoControlador {
    private final ProductoServicio productoServicio;

    /*
@GetMapping("/obtener/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(@PathVariable int codigoUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, usuarioServicio.obtenerUsuario(codigoUsuario)));
    }
*/
    @PostMapping("/crear")
    ResponseEntity<MensajeDTO> crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.crearProducto(productoDTO)));
    }

    @PutMapping("/actualizarProductos/{codigo}")
    ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigoProducto, @RequestBody ProductoGetDTO productoGetDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarProducto(codigoProducto,productoGetDTO)));
    }

    @PutMapping("/actualizarUnidades/{codigoProducto}")
    ResponseEntity<MensajeDTO> actualizarUnidades(@PathVariable int codigoProducto,@PathVariable int unidades) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarUnidades(codigoProducto,unidades)));
    }

    @GetMapping("/obtenerProducto/{codigoProducto}")
    public ResponseEntity<MensajeDTO> obtenerProducto(@PathVariable int codigoProducto) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, productoServicio.obtenerProducto(codigoProducto)) );
    }

    @GetMapping("/obtenerProductoMinMax/{categoria}")
    List<ProductoGetDTO> obtenerProductoMinimoMaximo(@PathVariable Categoria categoria) throws Exception
    {
        return productoServicio.obtenerProductoMinimoMaximo(categoria);
    }



}