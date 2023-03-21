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
public class DetalleCompra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    private Integer unidades;

    private String precio_producto;

    @ManyToOne
    private Compra compra;

    @ManyToOne
    private Producto producto;


}
