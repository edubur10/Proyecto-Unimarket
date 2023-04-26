package co.edu.uniquindio.proyecto.dto;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
=======
import jakarta.validation.constraints.NotNull;

>>>>>>> 45b36b54767b780797b81ba7278b76d3c6fa8ff2
public class CategoriaDTO {

    @NotNull
    private String categoria;
}
