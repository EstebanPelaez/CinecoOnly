package co.edu.uniquindio.CinecoOnly.CinecoOnly;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios.TicketRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TicketTest {

    @Autowired
    private TicketRepo ticketRepo;

    /**
     * En este método se crea un ticket, con el fin de realizar una prueba unitaria
     */

    @Test
    @Sql("classpath:ticketPrueba.sql")
    public void registrarTest(){

    }
}
