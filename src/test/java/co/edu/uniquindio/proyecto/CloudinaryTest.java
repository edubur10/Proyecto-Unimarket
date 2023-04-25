package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import com.cloudinary.utils.ObjectUtils;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
@Transactional
public class CloudinaryTest {
    @Autowired
    private CloudinaryServicio cloudinaryServicio;


    @Test
    public void subirImagenTest() throws Exception {
        // C:\Users\edwardo\Descargas
        File file = new File("C:\\Users\\edwardo\\Descargas\\prueba.jpg");

        cloudinaryServicio.subirImagen(file,"dto");
    }

    /*
    @Test
    public void eliminarImagenTest() throws Exception {
        File file = new File("C:\\Users\\edwardo\\Descargas\\prueba.jpg");
         cloudinaryServicio.eliminarImagen(file, ObjectUtils.asMap("Articulos","Articulos"));


    }

     */
}
