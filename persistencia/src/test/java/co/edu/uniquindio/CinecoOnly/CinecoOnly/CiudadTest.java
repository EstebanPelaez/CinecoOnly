package co.edu.uniquindio.cinecoonly.cinecoonly;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Ciudad;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;

    /**
     * En este método se crea un ciudad, con el fin de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:ciudadPrueba.sql")
    public void registrarTest(){

        Ciudad ciudad = new Ciudad(3, "Armenia");
        ciudadRepo.save(ciudad);

        Assertions.assertNotNull(ciudadRepo.findById(3));
    }

    /**
     * En este método se actualiza el nombre de la pelicula que está en el repositorio peliculaPrueba.sql, con el fin
     * de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:ciudadPrueba.sql")
    public void actualizarTest(){

        Ciudad ciudad = ciudadRepo.findById(4).orElse(null);

        ciudad.setNombre("Medellin");
        ciudadRepo.save(ciudad);

        Ciudad ciudadNew = ciudadRepo.findById(4).orElse(null);
        Assertions.assertEquals("Medellin", ciudadNew.getNombre());
    }

    /**
     * En este método se elimina una pelicula que esta en el repositorio peliculaPrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:ciudadPrueba.sql")
    public void eliminarTest() {

        ciudadRepo.deleteById(4);
        Ciudad peliculaNew = ciudadRepo.findById(3).orElse(null);

        Assertions.assertNull(peliculaNew);
    }
}
