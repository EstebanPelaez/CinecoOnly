package co.edu.uniquindio.CinecoOnly.CinecoOnly.bean;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Pelicula;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.CarteleraSinPeliculasException;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.PeliculaNoEncontradaException;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.servicios.FuncionServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@ViewScoped
@Component
public class CarteleraBean {

    @Autowired
    private FuncionServicio funcionServicio;

    @Getter @Setter
    private List<Pelicula> cartelera;

    @Getter @Setter
    private List<Pelicula> proximosEstrenos;

    @PostConstruct
    public void inicializar(){

        try{
            cartelera = funcionServicio.listarCartelera();
            proximosEstrenos = funcionServicio.listarProximosEstrenos();

        }catch(CarteleraSinPeliculasException e){
            e.getMessage();
        }

    }

    public String irADetalle(String id) {
        return "/informacionPelicula?faces-redirect=true&amp;pelicula="+id;
    }
}
