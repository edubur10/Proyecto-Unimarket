package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO { //DTO --> Datos de trnsferencia simples

    private String mensaje;

    private int codigoUsuario;

    private int codigoProducto;

}
