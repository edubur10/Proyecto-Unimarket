package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
public class Imagen implements Serializable {

    @ManyToOne
    private Producto codigo_producto;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementable codigo
    private Integer id_imagen;

    private String ruta;


}
