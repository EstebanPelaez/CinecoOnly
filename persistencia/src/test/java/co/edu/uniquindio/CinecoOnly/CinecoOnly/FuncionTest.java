package co.edu.uniquindio.CinecoOnly.CinecoOnly;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Cliente;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Funcion;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios.FuncionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {

    @Autowired
    private FuncionRepo funcionRepo;

    /**
     * En este método se crea un cliente, con el fin de realizar una prueba unitaria
     */

    @Test
    @Sql("classpath:funcionPrueba.sql")
    public void registrarTest(){

        Funcion funcion = new Funcion(5, "Disponible");
        funcionRepo.save(funcion);

        Assertions.assertNotNull(funcionRepo.findById(1));
    }

}
