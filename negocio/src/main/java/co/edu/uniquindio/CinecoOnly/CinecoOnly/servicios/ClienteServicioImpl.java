package co.edu.uniquindio.CinecoOnly.CinecoOnly.servicios;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Cliente;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.ClienteExistenteException;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.DatosErroneosException;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.UsuarioNoEncontradoException;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.repositorios.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepo clienteRepo;

    @Override
    public Cliente registrarCliente(Cliente c) throws ClienteExistenteException {

        Optional<Cliente> buscado = clienteRepo.findById(c.getCodigo());

        if(buscado.isPresent()){
            throw new ClienteExistenteException("El codigo del cliente ya existe");
        }
        //buscado = null; -> terminar
        /*if(buscado.isPresent()){
            throw new Exception("El email del cliente ya está registrado");
        }*/

       return clienteRepo.save(c);
    }

    @Override
    public Cliente actualizarCliente(Cliente c) throws Exception {
        return null;
    }

    @Override
    public Cliente iniciarSesion(String email, String contrasenia) throws DatosErroneosException {
        return clienteRepo.findByEmailAndContrasenia(email, contrasenia).orElseThrow( () -> new DatosErroneosException("Los datos de autenticacion son incorrectos"));
    }

    @Override
    public Cliente recuperarContrasenia(String email, Integer codigo) throws UsuarioNoEncontradoException{
        return  clienteRepo.findByEmailAndCodigo(email,codigo).orElseThrow( () -> new UsuarioNoEncontradoException("El usuario no existe"));
    }

}
