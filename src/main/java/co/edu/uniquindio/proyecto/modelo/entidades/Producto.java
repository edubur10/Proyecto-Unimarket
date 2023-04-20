package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementable codigo
    private int codigo;

    private Estado estado; //preguntar

    private LocalDateTime fechaLimite;

    private LocalDateTime fechaCreacion;

    private String nombre;

    private String descripcion;

    private int unidades;

    private float precio;

    @ElementCollection
    private List<String> imagenes;

    @ElementCollection
    private List<Categoria> categorias;

    @OneToMany (mappedBy = "producto")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto")
    private List<ProductoModerador> productoModeradors;

    @OneToMany(mappedBy = "producto")
    private List<Usuario> favoritos;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompras;

    @Builder
    public Producto(Estado estado, LocalDateTime fechaLimite, LocalDateTime fechaCreacion,
                    String nombre, String descripcion, int unidades, float precio, List<String> imagenes,
                    List<Categoria> categorias, List<Comentario> comentarios, List<ProductoModerador> productoModeradors,
                    List<Usuario> favoritos, Usuario usuario, List<DetalleCompra> detalleCompras) {
        this.estado = estado;
        this.fechaLimite = fechaLimite;
        this.fechaCreacion = LocalDateTime.now();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.precio = precio;
        this.imagenes = imagenes;
        this.categorias = categorias;
        this.comentarios = comentarios;
        this.productoModeradors = productoModeradors;
        this.favoritos = favoritos;
        this.usuario = usuario;
        this.detalleCompras = detalleCompras;
    }
}
