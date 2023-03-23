package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private String nombre;

    @NotBlank
    @NotNull
    @Email
    private String email;


    @NotNull
    @NotBlank
    @Length(min = 7, max = 50, message = "La contraseña debe ser de maximo 50 caracteres")
    private String password;

    private String direccion;
    private String telefono;
}
