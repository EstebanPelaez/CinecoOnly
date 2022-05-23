package co.edu.uniquindio.cinecoonly.cinecoonly.repositorios;


import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepo extends JpaRepository<Sala, Integer> {

    //Consultas
}
