package co.edu.uniquindio.cinecoonly.cinecoonly.repositorios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

    //Consultas
    Optional<Cliente> findByEmailAndContrasenia(String email, String contrasenia);

    Optional<Cliente> findByEmailAndCodigo(String email, Integer codigo);
}
