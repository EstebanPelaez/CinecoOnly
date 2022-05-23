package co.edu.uniquindio.CinecoOnly.CinecoOnly;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Funcion;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Sala;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios.FuncionRepo;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios.SalaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SalaTest {

    @Autowired
    private SalaRepo salaRepo;

    @Autowired
    private FuncionRepo funcionRepo;

    /**
     * En este método se crea una sala, con el fin de realizar una prueba unitaria
     */

    @Test
    @Sql("classpath:salaPrueba.sql")
    public void registrarTest(){

        Funcion funcion = funcionRepo.findById(1).orElse(null);
        Sala sala = new Sala(2, "Disponible", funcion);
        salaRepo.save(sala);

        Assertions.assertNotNull(salaRepo.findById(2));
    }
    /**
     * En este método se actualiza el nombre de una sala que está en el repositorio clientePrueba.sql, con el fin
     * de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:salaPrueba.sql")
    public void actualizarTest(){

        Sala salaNew = salaRepo.findById(2).orElse(null);
        salaNew.setEstado("ocupado");
        salaRepo.save(salaNew);

        Sala salaNuevo = salaRepo.findById(2).orElse(null);
        Assertions.assertEquals("ocupado", salaNuevo.getEstado());
    }

    /**
     * En este método se elimina una sala que esta en el repositorio salaPrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:salaPrueba.sql")
    public void eliminarTest(){

        salaRepo.deleteById(2);
        Sala salaBuscado = salaRepo.findById(1).orElse(null);

        Assertions.assertNull(salaBuscado);
    }
}
