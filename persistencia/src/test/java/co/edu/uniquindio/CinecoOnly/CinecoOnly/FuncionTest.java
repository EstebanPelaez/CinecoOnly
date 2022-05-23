package co.edu.uniquindio.cinecoonly.cinecoonly;

import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.FuncionRepo;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.PeliculaRepo;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.SalaRepo;
import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {

    @Autowired
    private FuncionRepo funcionRepo;
    @Autowired
    private PeliculaRepo peliculaRepo;

    @Autowired
    private SalaRepo salaRepo;

    /**
     * En este método se crea un cliente, con el fin de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:funcionPrueba.sql")
    public void registrarTest(){

        Sala sala = salaRepo.findById(4).orElse(null);
        Pelicula pelicula = peliculaRepo.findById(30).orElse(null);
        LocalDate fecha = LocalDate.of(2023, 5 , 15);

        Funcion funcion = new Funcion(6, fecha, null, null, pelicula, sala, "Disponible");
        funcionRepo.save(funcion);

        Assertions.assertNotNull(funcionRepo.findById(1));
    }

    /**
     * En este método se actualiza el estado de la funcion que está en el repositorio funcionPrueba.sql, con el fin
     * de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:funcionPrueba.sql")
    public void actualizarTest(){

        Funcion funcion = funcionRepo.findById(4).orElse(null);

        funcion.setEstado("Ocupado");
        funcionRepo.save(funcion);

        Funcion funcionNew = funcionRepo.findById(4).orElse(null);
        Assertions.assertEquals("Ocupado", funcionNew.getEstado());
    }

    /**
     * En este método se elimina una funcion que esta en el repositorio funcionPrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:funcionPrueba.sql")
    public void eliminarTest() {

        funcionRepo.deleteById(5);
        Funcion funcionNew = funcionRepo.findById(5).orElse(null);

        Assertions.assertNull(funcionNew);
    }
}
