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
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Moderador extends Persona {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    @OneToMany(mappedBy = "moderador")
    private List<ProductoModerador> productoModeradors;

}
