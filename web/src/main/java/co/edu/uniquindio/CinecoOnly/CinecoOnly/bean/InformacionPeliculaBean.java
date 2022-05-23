package co.edu.uniquindio.cinecoonly.cinecoonly.bean;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Pelicula;
import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Pelicula;
import co.edu.uniquindio.cinecoonly.cinecoonly.servicios.FuncionServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@ViewScoped
@Component
public class InformacionPeliculaBean{

    @Getter @Setter
    private Pelicula pelicula;

    @Autowired
    private FuncionServicio funcionServicio;

    @Value("#{param['pelicula']}")
    private String codigoPelicula;

    @PostConstruct
    public void inicializar(){

        if (codigoPelicula != null && !codigoPelicula.isEmpty()) {
            Integer codigo = Integer.parseInt(codigoPelicula);
            try {
                pelicula = funcionServicio.obtenerPelicula(codigo);
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }
    public String seleccionarAsiento(String id){
        return "/horarios?faces-redirect=true&amp;pelicula="+id;
    }
}
