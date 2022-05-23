package co.edu.uniquindio.cinecoonly.cinecoonly;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.*;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.*;
import com.mysql.cj.xdevapi.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TicketTest {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private AsientoRepo asientoRepo;

    @Autowired
    private TipoTicketRepo tipo_ticketRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private FuncionRepo funcionRepo;

    /**
     * En este método se crea un ticket, con el fin de realizar una prueba unitaria
     */

    @Test
    @Sql("classpath:ticketPrueba.sql")
    public void registrarTest(){

        LocalDate fecha = LocalDate.of(2023, 5 , 15);
        Cliente cliente = clienteRepo.getById(1);
        Funcion funcion = funcionRepo.getById(1);
        TipoTicket tipoTicket = tipo_ticketRepo.getById(1);
        Asiento asiento = asientoRepo.getById(1);

        Ticket ticket = new Ticket(2, fecha, "Disponible", tipoTicket, asiento, cliente, funcion);
        ticketRepo.save(ticket);

        Assertions.assertNotNull(ticketRepo.findById(2));
    }

    /**
     * En este método se actualiza el nombre de una sala que está en el repositorio clientePrueba.sql, con el fin
     * de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:ticketPrueba.sql")
    public void actualizarTest(){

        Ticket ticketNew = ticketRepo.findById(1).orElse(null);
        ticketNew.setEstado("Ocupado");
        ticketRepo.save(ticketNew);

        Ticket ticketNuevo = ticketRepo.findById(1).orElse(null);
        Assertions.assertEquals("Ocupado", ticketNuevo.getEstado());
    }

    /**
     * En este método se elimina una sala que esta en el repositorio salaPrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:ticketPrueba.sql")
    public void eliminarTest(){

        ticketRepo.deleteById(1);
        Ticket ticketBuscado = ticketRepo.findById(1).orElse(null);

        Assertions.assertNull(ticketBuscado);
    }
}
