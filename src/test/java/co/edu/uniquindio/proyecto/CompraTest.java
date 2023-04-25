package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.MetodoPago;
import co.edu.uniquindio.proyecto.modelo.entidades.Estado;
import co.edu.uniquindio.proyecto.modelo.entidades.MetodoPago;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@SpringBootTest
@Transactional
public class CompraTest
{

    @Autowired
    private CompraServicio compraServicio;

    //Pablo Andres Sanchez
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComprasUsuarioTest() throws Exception
    {

        List<CompraGetDTO> lista = compraServicio.listarCompras(1);
        Assertions.assertEquals(1,lista.size());
        System.out.println("lista = " + lista);

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void crearCompraTest()
    {
        try {

            CompraDTO usuarioDTO = new CompraDTO( 5, MetodoPago.TARJETA_CREDITO, );
            compraServicio.crearCompra(usuarioDTO);

            Assertions.assertNotNull(usuarioDTO);

            System.out.println(usuarioDTO.getMetodoPago());

        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    //    @Test
//    @Sql("classpath:dataset.sql")
//    public void crearCompraTest()
//    {
//
//        try {
//
//            CompraDTO usuarioDTO = new CompraDTO(6, 5, MetodoPago.TARJETA_CREDITO);
//            compraServicio.crearCompra(usuarioDTO);
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }


    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompraTest()
    {
        try
        {
            CompraGetDTO compraGetDTO = compraServicio.obtenerCompra(2);

            System.out.println( compraGetDTO);

        } catch (Exception e)
        {
            throw new RuntimeException(e);

        }
    }
}