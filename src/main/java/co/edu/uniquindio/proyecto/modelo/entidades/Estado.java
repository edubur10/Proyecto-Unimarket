package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estado implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;

    @OneToMany(mappedBy = "estado")
    private List<ProductoModerador> productoModeradors;

}
