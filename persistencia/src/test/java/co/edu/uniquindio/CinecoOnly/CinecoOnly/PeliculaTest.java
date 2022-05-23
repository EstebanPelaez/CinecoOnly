package co.edu.uniquindio.CinecoOnly.CinecoOnly;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Cliente;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Pelicula;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios.PeliculaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaTest {

    @Autowired
    private PeliculaRepo peliculaRepo;

    /**
     * En este método se crea una pelicula, con el fin de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:peliculaPrueba.sql")
    public void registrarTest(){

        LocalDate fecha = LocalDate.of(2022, 5 , 15);
        LocalDate fechainico = LocalDate.of(2021, 5 , 15);
        Pelicula pelicula = new Pelicula(33, "Es demasiado buena", fecha, fechainico, null, "Shrk 2");
        peliculaRepo.save(pelicula);

        Assertions.assertNotNull(peliculaRepo.findById(66));
    }

    /**
     * En este método se actualiza el nombre de la pelicula que está en el repositorio peliculaPrueba.sql, con el fin
     * de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:peliculaPrueba.sql")
    public void actualizarTest(){

        Pelicula pelicula = peliculaRepo.findById(0).orElse(null);

        pelicula.setNombre("X-men");
        peliculaRepo.save(pelicula);

        Pelicula pelicualnew = peliculaRepo.findById(0).orElse(null);
        Assertions.assertEquals("X-men", pelicualnew.getNombre());
    }

    /**
     * En este método se elimina una pelicula que esta en el repositorio peliculaPrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:peliculaPrueba.sql")
    public void eliminarTest(){

        peliculaRepo.deleteById(0);
        Pelicula peliculaNew = peliculaRepo.findById(0).orElse(null);

        Assertions.assertNull(peliculaNew);
    }
}
