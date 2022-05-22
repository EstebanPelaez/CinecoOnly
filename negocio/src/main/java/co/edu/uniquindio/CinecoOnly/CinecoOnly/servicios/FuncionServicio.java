package co.edu.uniquindio.CinecoOnly.CinecoOnly.servicios;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Funcion;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Pelicula;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.CarteleraSinPeliculasException;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.PeliculaExistenteException;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.PeliculaNoEncontradaException;

import java.util.List;

public interface FuncionServicio {

    List<Pelicula> listarCartelera() throws CarteleraSinPeliculasException;

    List<Pelicula> listarProximosEstrenos() throws CarteleraSinPeliculasException;

    Funcion publicarFuncion(Funcion f) throws PeliculaExistenteException;

    void actualizarFuncion(Funcion f) throws PeliculaNoEncontradaException;

    void eliminarFuncion(Funcion f) throws PeliculaNoEncontradaException;

    Pelicula obtenerPelicula(Integer codigo) throws PeliculaNoEncontradaException;
}
