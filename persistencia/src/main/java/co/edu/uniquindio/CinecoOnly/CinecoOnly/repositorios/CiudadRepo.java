package co.edu.uniquindio.cinecoonly.cinecoonly.repositorios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

    //Consultas
}
