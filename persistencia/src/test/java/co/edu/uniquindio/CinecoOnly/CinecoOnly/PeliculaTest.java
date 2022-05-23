package co.edu.uniquindio.cinecoonly.cinecoonly;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Pelicula;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.PeliculaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaTest {

    @Autowired
    private PeliculaRepo peliculaRepo;

    Logger logger;

    /**
     * En este método se crea una pelicula, con el fin de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:peliculaPrueba.sql")
    public void registrarTest(){

        LocalDate fecha = LocalDate.of(2023, 5 , 15);
        LocalDate fechainico = LocalDate.of(2022, 5 , 25);
        Pelicula pelicula = new Pelicula(33, "Shrek 3", fechainico, fecha, null, "De las mejores peliculas");
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

        Pelicula pelicula = peliculaRepo.findById(30).orElse(null);

        pelicula.setNombre("X-men");
        peliculaRepo.save(pelicula);

        Pelicula pelicualnew = peliculaRepo.findById(30).orElse(null);
        Assertions.assertEquals("X-men", pelicualnew.getNombre());
    }

    /**
     * En este método se elimina una pelicula que esta en el repositorio peliculaPrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:peliculaPrueba.sql")
    public void eliminarTest(){

        peliculaRepo.deleteById(29);
        Pelicula peliculaNew = peliculaRepo.findById(0).orElse(null);

        Assertions.assertNull(peliculaNew);
    }

    /**
     * En este método se listan las peliculas que esta en el cartelera en peliculaPrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:peliculaPrueba.sql")
    public void listarPeliculas(){

        List<Pelicula> peliculas = peliculaRepo.listarCartelera();
        int contador =0;
        for(Pelicula miPeli : peliculas){
            contador = +1;
            if (peliculas.size()==contador){
                logger.log(Level.INFO,miPeli.getNombre());
            }else{
                logger.log(Level.INFO,"No concuerda la cantidad de peliculas");
            }
        }
    }

    /**
     * En este método se listan las peliculas que esta en el cartelera en peliculaPrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:peliculaPrueba.sql")
    public void listarPeliculasProximas(){

        List<Pelicula> peliculas = peliculaRepo.listarProximosEstrenos();
        int contador =0;
        for(Pelicula miPeli : peliculas){
            contador = +1;
            if (peliculas.size()==contador){
                logger.log(Level.INFO,miPeli.getNombre());
            }else{
                logger.log(Level.INFO,"No concuerda la cantidad de peliculas");
            }
        }
    }

}
