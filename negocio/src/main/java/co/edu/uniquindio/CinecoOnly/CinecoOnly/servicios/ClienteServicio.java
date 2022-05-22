package co.edu.uniquindio.CinecoOnly.CinecoOnly.servicios;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Cliente;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.ClienteExistenteException;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.DatosErroneosException;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.UsuarioNoEncontradoException;

public interface ClienteServicio {

    Cliente registrarCliente(Cliente c) throws ClienteExistenteException;

    Cliente actualizarCliente(Cliente c) throws UsuarioNoEncontradoException;

    Cliente iniciarSesion(String email, String contrasenia) throws DatosErroneosException;

    Cliente recuperarContrasenia(String email, Integer codigo) throws UsuarioNoEncontradoException;

}
