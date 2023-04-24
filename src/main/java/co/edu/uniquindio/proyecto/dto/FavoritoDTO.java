package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoritoDTO {
    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private int idUsuario;
}
