package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.entidades.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
//import org.hibernate.mapping.Map;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {

    @Length(max = 140)
    @NotNull
    @NotBlank
    private String nombre;

    @NotBlank
    @NotNull
    private String descripcion;

    @PositiveOrZero
    private int unidades;

    @PositiveOrZero
    private float precio;

    @Positive
    private int codigoVendedor;

    private List<String> imagenes; //PREGUNTA ...!!!!

    private List<Categoria> categorias;

}
