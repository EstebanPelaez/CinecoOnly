package co.edu.uniquindio.cinecoonly.cinecoonly.servicios;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Funcion;
import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Pelicula;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.CarteleraSinPeliculasException;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.PeliculaExistenteException;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.PeliculaNoEncontradaException;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.FuncionRepo;
import co.edu.uniquindio.cinecoonly.cinecoonly.repositorios.PeliculaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionServicioImpl implements  FuncionServicio{

    @Autowired
    private FuncionRepo funcionRepo;

    @Autowired
    private PeliculaRepo peliculaRepo;

    @Override
    public List<Pelicula> listarCartelera() throws CarteleraSinPeliculasException {

        return peliculaRepo.listarCartelera();
    }

    @Override
    public List<Pelicula> listarProximosEstrenos() throws CarteleraSinPeliculasException{

        return peliculaRepo.listarProximosEstrenos();
    }
    @Override
    public Funcion publicarFuncion(Funcion f) throws PeliculaExistenteException {

        try{
            return funcionRepo.save(f);
        }catch (Exception e){
            throw new PeliculaExistenteException(e.getMessage());
        }
    }

    @Override
    public void actualizarFuncion(Funcion f) throws PeliculaNoEncontradaException {
        try {
            funcionRepo.save(f);

        }catch(Exception e){
            throw new PeliculaNoEncontradaException(e.getMessage());
        }
    }

    @Override
    public void eliminarFuncion(Funcion f) throws PeliculaNoEncontradaException {
        Optional<Funcion> funcion = funcionRepo.findById(f.getCodigoFuncion());
        if(funcion.isEmpty()){
            throw new PeliculaNoEncontradaException("El codigo del producto no existe");
        }else{
            funcionRepo.deleteById(f.getCodigoFuncion());
        }
    }

    @Override
    public Pelicula obtenerPelicula(Integer codigo) throws PeliculaNoEncontradaException {
        return peliculaRepo.findById(codigo).orElseThrow(() -> new PeliculaNoEncontradaException("El código de la pelicula no es válido"));
    }


}
