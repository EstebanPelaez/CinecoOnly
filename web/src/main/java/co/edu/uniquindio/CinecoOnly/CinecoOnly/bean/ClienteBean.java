package co.edu.uniquindio.CinecoOnly.CinecoOnly.bean;

import co.edu.uniquindio.CinecoOnly.CinecoOnly.exceptions.ClienteExistenteException;
import lombok.Getter;
import lombok.Setter;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Cliente;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades.Ciudad;
import co.edu.uniquindio.CinecoOnly.CinecoOnly.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

@ViewScoped
@Component
public class ClienteBean implements Serializable{

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private String telefono1;

    @Getter @Setter
    private String telefono2;

    @Getter @Setter
    private Ciudad ciudad;

    @Autowired
    private ClienteServicio clienteServicio;

    @PostConstruct
    public void inicializar(){
        cliente = new Cliente();
    }

    public void registrarCliente(){
        try{
            clienteServicio.registrarCliente(cliente);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (ClienteExistenteException e) {
            e.getMessage();
        }
    }
}
