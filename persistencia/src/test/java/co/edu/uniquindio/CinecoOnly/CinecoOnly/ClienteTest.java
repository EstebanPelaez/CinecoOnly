package co.edu.uniquindio.cinecoonly.cinecoonly;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Ciudad;
import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Cliente;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    Logger logger;

    /**
     * En este método se crea un cliente, con el fin de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:clientePrueba.sql")
    public void registrarTest(){

        Cliente cliente = new Cliente(1, "Pedro", "Pedro@gmail.com", "123456", "Disponible");
        clienteRepo.save(cliente);

        Assertions.assertNotNull(clienteRepo.findById(1));
    }

    /**
     * En este método se actualiza el nombre de un cliente que está en el repositorio clientePrueba.sql, con el fin
     * de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:clientePrueba.sql")
    public void actualizarTest(){

        Cliente cliente = clienteRepo.findById(2).orElse(null);

        cliente.setNombre("Santiago");
        clienteRepo.save(cliente);

        Cliente clienteNew = clienteRepo.findById(2).orElse(null);
        Assertions.assertEquals("Santiago", clienteNew.getNombre());
    }

    /**
     * En este método se elimina un cliente que esta en el repositorio clinetePrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:clientePrueba.sql")
    public void eliminarTest() {

        clienteRepo.deleteById(0);
        Cliente clienteNew = clienteRepo.findById(0).orElse(null);

        Assertions.assertNull(clienteNew);
    }

    @Test
    @Sql("classpath:clientePrueba.sql")
    public void buscarCorreo(){

        Optional<Cliente> cliente = clienteRepo.findByEmailAndCodigo("camilon@gmail.com", 2);
        if (cliente.isPresent()) {
            logger.log(Level.INFO,cliente.get().getNombre());
        } else {
            logger.log(Level.INFO,"No existe este correo o este codigo asociado a un cliente");
        }
    }

    @Test
    @Sql("classpath:clientePrueba.sql")
    public void buscarCorreoyContrasenia(){

        Optional<Cliente> cliente = clienteRepo.findByEmailAndContrasenia("camilon@gmail.com", "123223");
        if (cliente.isPresent()) {
            logger.log(Level.INFO,cliente.get().getNombre());
        } else {
            logger.log(Level.INFO,"No existe este correo o esta contrasenia asociado a un cliente");
        }
    }
}
