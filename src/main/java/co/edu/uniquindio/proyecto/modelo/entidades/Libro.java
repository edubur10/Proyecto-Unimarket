package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Libro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String isbn;
    private String nombre;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Genero> genero;
    private int unidades;
    private int anio;
}