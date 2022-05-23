package co.edu.uniquindio.CinecoOnly.CinecoOnly;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Cliente;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Sucursal;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios.SucursalRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Sucursaltest {

    @Autowired
    private SucursalRepo sucursalRepo;

    /**
     * En este método se crea un cliente, con el fin de realizar una prueba unitaria
     */

    @Test
    @Sql("classpath:sucursalPrueba.sql")
    public void registrarTest(){

        Sucursal sucursal = new Sucursal(5, "Calima", "Calle 10", "Disponible");
        sucursalRepo.save(sucursal);

        Assertions.assertNotNull(sucursalRepo.findById(5));
    }

}
