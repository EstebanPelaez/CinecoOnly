package co.edu.uniquindio.cinecoonly.cinecoonly.bean;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Asiento;
import co.edu.uniquindio.cinecoonly.cinecoonly.servicios.FuncionServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@ViewScoped
@Component
public class SalaBean {

    @Autowired
    private FuncionServicio funcionServicio;

    @Getter @Setter
    private List<Asiento> listaAsientos;

    @PostConstruct
    public void inicializar(){
        System.out.println("Terminar");
    }

}
