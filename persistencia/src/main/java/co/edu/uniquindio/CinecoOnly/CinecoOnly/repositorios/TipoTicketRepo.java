package co.edu.uniquindio.cinecoonly.cinecoonly.repositorios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.TipoTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTicketRepo extends JpaRepository<TipoTicket, Integer> {

    //Consultas
}
