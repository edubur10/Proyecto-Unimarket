package co.edu.uniquindio.proyecto.repositorios;


import co.edu.uniquindio.proyecto.modelo.entidades.Compra;
import co.edu.uniquindio.proyecto.modelo.entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra, Integer> {
    @Query("SELECT dc FROM DetalleCompra dc WHERE dc.producto.codigo = :codigo")
    List<DetalleCompra> listarPorCodigoProducto(@Param("codigo") Integer codigo);

    @Query("SELECT dc FROM DetalleCompra dc WHERE dc.compra = :compra")
    List<DetalleCompra> listarPorCompra(@Param("compra") Compra compra);
}
