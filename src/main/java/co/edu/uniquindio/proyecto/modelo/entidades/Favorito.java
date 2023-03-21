package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Favorito implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @ManyToOne
    private Producto producto;

    @Id
    @EqualsAndHashCode.Include
    @ManyToOne
    private Usuario usuario;


}
