package co.edu.uniquindio.CinecoOnly.CinecoOnly;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Cliente;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios.CiudadRepo;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    /**
     * En este método se crea un cliente, con el fin de realizar una prueba unitaria
     */

    @Test
    @Sql("classpath:clientePrueba.sql")
    public void registrarTest(){

    Cliente cliente = new Cliente(1, "Esteban", "esteban@gmail.com", "1234516", "Soltero");
    clienteRepo.save(cliente);

    Assertions.assertNotNull(clienteRepo.findById(1));
    }

    /**
     * En este método se actualiza el email del cliente que está en el repositorio clientePrueba.sql, con el fin
     * de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:usuarioPrueba.sql")
    public void actualizarTest(){

        Cliente clienteGuardado = clienteRepo.findById(0).orElse(null);
        clienteGuardado.setNombre("Diego");
        clienteRepo.save(clienteGuardado);

        Cliente clienteNuevo = clienteRepo.findById(0).orElse(null);
        Assertions.assertEquals("Diego", clienteNuevo.getNombre());
    }

    /**
     * En este método se elimina el cliente que esta en el repositorio clientePrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:usuarioPrueba.sql")
    public void eliminarTest(){

        clienteRepo.deleteById(2);
        Cliente clienteBuscado = clienteRepo.findById(1).orElse(null);

        Assertions.assertNull(clienteBuscado);
    }

    /**
     *En este método se realiza la consulta de clientes a través del email y codigo.
     */
    @Test
    @Sql("classpath:usuarioPrueba.sql")
    public void filtraEmailPrueba(){
        Optional<Cliente> cliente = clienteRepo.findByEmailAndCodigo("camilon@gmail.com", 2);

        if(cliente.isPresent()){
            System.out.println(cliente.get());
        }else{
            System.out.println("No existe este usuario");
        }
    }

    /**
     *En este método se realiza la consulta de clientes a través del email y contraseña.
     */
    @Test
    @Sql("classpath:usuarioPrueba.sql")
    public void filtraEmailContraPrueba(){
        Optional<Cliente> cliente = clienteRepo.findByEmailAndContrasenia("camilon@gmail.com", "123223");

        if(cliente.isPresent()){
            System.out.println(cliente.get());
        }else{
            System.out.println("No existe este usuario");
        }
    }

}
