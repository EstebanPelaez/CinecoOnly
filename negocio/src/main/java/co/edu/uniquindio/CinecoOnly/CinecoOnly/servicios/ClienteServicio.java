package co.edu.uniquindio.cinecoonly.cinecoonly.servicios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Cliente;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.ClienteExistenteException;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.DatosErroneosException;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.UsuarioNoEncontradoException;

public interface ClienteServicio {

    Cliente registrarCliente(Cliente c) throws ClienteExistenteException;

    Cliente actualizarCliente(Cliente c) throws UsuarioNoEncontradoException;

    Cliente iniciarSesion(String email, String contrasenia) throws DatosErroneosException;

    Cliente recuperarContrasenia(String email, Integer codigo) throws UsuarioNoEncontradoException;

}
