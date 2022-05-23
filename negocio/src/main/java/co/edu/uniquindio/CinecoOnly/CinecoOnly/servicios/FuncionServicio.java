package co.edu.uniquindio.cinecoonly.cinecoonly.servicios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Funcion;
import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Pelicula;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.CarteleraSinPeliculasException;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.PeliculaExistenteException;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.PeliculaNoEncontradaException;

import java.util.List;

public interface FuncionServicio {

    List<Pelicula> listarCartelera() throws CarteleraSinPeliculasException;

    List<Pelicula> listarProximosEstrenos() throws CarteleraSinPeliculasException;

    Funcion publicarFuncion(Funcion f) throws PeliculaExistenteException;

    void actualizarFuncion(Funcion f) throws PeliculaNoEncontradaException;

    void eliminarFuncion(Funcion f) throws PeliculaNoEncontradaException;

    Pelicula obtenerPelicula(Integer codigo) throws PeliculaNoEncontradaException;
}
