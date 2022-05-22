package co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {

    //Consultas

}
