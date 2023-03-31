package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioGetDTO {

    private int codigo;

    private String nombre;

    private String email;

    private String direccion;

    private List<String> telefono;

}
