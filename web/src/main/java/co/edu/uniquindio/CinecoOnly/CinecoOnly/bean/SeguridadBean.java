package co.edu.uniquindio.cinecoonly.cinecoonly.bean;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Cliente;
import co.edu.uniquindio.cinecoonly.cinecoonly.servicios.ClienteServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Getter @Setter
    private boolean autenticado;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String contrasenia;

    @Getter @Setter
    private Cliente clienteSesion;


    @Autowired
    private ClienteServicio clienteServicio;

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public String iniciarSesion(){

        if (!email.isEmpty() && !contrasenia.isEmpty()) {

            try{
                 clienteSesion = clienteServicio.iniciarSesion(email,contrasenia);
                 autenticado=true;
                 return "index?faces-redirect=true";
            }catch(Exception e){
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }

        }else{
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Debe llenar los datos requeridos");
            FacesContext.getCurrentInstance().addMessage("add-cart", fm);
        }
        return null;
    }
}
