package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementable codigo
    private int codigo;

    private boolean estado; //preguntar

    private LocalDateTime fechaLimite;

    private String nombre;

    private String descripcion;

    private int unidades;

    private float precio;

    private int codigoVendedor;

    @OneToMany (mappedBy = "codigo_producto") //PREGUNTA!!! STRING O IMAGEN
    private List<Imagen> imagenes;

    @OneToMany (mappedBy = "codigo_producto")
    private List<Categoria> categorias;

    @OneToMany (mappedBy = "producto")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto")
    private List<ProductoModerador> productoModeradors;

    @OneToMany(mappedBy = "producto")
    private List<Favorito> favoritos;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompras;
}
