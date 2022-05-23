package co.edu.uniquindio.cinecoonly.cinecoonly.repositorios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepo extends JpaRepository<Asiento, Integer> {

    //Consultas
}
