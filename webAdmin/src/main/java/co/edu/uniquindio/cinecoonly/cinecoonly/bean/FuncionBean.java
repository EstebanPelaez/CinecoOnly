package co.edu.uniquindio.cinecoonly.cinecoonly.bean;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Funcion;
import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Pelicula;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.PeliculaExistenteException;
import co.edu.uniquindio.cinecoonly.cinecoonly.servicios.FuncionServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@ViewScoped
@Component
public class FuncionBean implements Serializable {

    @Getter @Setter
    private Funcion funcion;

    @Getter @Setter
    private List<Date> rangoFechas;

    @Autowired
    private FuncionServicio funcionServicio;

    @PostConstruct
    public void inicializar(){
        Pelicula pelicua = new Pelicula();
        funcion = new Funcion();
        funcion.setPelicula(pelicua);
    }

    public void registrarFuncion(){

        try{
            funcion.getPelicula().setFechaInicio(rangoFechas.get(0).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            funcion.getPelicula().setFechaFin(rangoFechas.get(1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            funcionServicio.publicarFuncion(funcion);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        catch(PeliculaExistenteException e){
            e.getMessage();
        }

    }

}
