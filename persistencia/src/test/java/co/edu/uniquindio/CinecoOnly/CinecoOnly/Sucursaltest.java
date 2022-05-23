package co.edu.uniquindio.cinecoonly.cinecoonly;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Ciudad;
import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Sucursal;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.CiudadRepo;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.SucursalRepo;
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

    @Autowired
    private CiudadRepo ciudadRepo;

    /**
     * En este método se crea un cliente, con el fin de realizar una prueba unitaria
     */

    @Test
    @Sql("classpath:sucursalPrueba.sql")
    public void registrarTest(){

        Ciudad ciudad = ciudadRepo.getById(4);
        Sucursal sucursal = new Sucursal(5, "Calima", "Calle 10", "Disponible", ciudad);
        sucursalRepo.save(sucursal);

        Assertions.assertNotNull(sucursalRepo.findById(5));
    }

    /**
     * En este método se actualiza el nombre de una sucursal que está en el repositorio sucursalPrueba.sql, con el fin
     * de realizar una prueba unitaria
     */
    @Test
    @Sql("classpath:sucursalPrueba.sql")
    public void actualizarTest(){

        Sucursal sucursalNew = sucursalRepo.findById(4).orElse(null);
        sucursalNew.setNombre("Portal del Quindio");
        sucursalRepo.save(sucursalNew);

        Sucursal sucursalNuevo = sucursalRepo.findById(4).orElse(null);
        Assertions.assertEquals("Portal del Quindio", sucursalNuevo.getNombre());
    }

    /**
     * En este método se elimina una sucursal que esta en el repositorio sucursalPrueba.sql, con el fin de realizar
     * una prueba unitaria
     */
    @Test
    @Sql("classpath:sucursalPrueba.sql")
    public void eliminarTest(){

        sucursalRepo.deleteById(4);
        Sucursal sucursal = sucursalRepo.findById(4).orElse(null);

        Assertions.assertNull(sucursal);
    }


}
