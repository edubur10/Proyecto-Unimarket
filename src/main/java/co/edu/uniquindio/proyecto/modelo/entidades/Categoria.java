package co.edu.uniquindio.proyecto.modelo.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Categoria {

    @ManyToOne
    private Producto codigo_producto;

    @Id
    @EqualsAndHashCode.Include
    private Integer codigoCategoria;
    private String nombre;

}
