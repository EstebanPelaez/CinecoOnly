package co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.TipoTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTicketRepo extends JpaRepository<TipoTicket, Integer> {

    //Consultas
}
