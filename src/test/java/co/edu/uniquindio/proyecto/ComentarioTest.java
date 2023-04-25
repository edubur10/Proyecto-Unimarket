package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class ComentarioTest
{
    @Autowired
    private ComentarioServicio comentarioServicio;

    //Diego Alejandro Lopez
    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentarioTest()
    {
        try {
            ComentarioDTO comentarioDTO = new ComentarioDTO("No me gusto el producto", 1, 3);
            comentarioServicio.crearComentario(comentarioDTO);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listComentariosTest()
    {
        List<ComentarioGetDTO> comentarioLista = comentarioServicio.listarComentarios(7);

        Assertions.assertEquals(2, comentarioLista.size());
    }


}