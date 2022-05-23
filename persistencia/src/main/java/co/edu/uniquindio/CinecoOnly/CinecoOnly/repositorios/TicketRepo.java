package co.edu.uniquindio.cinecoonly.cinecoonly.repositorios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    //Consultas
}
