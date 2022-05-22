package co.edu.uniquindio.cinecoonly.cinecoonly.bean;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Cliente;
import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Mail;
import co.edu.uniquindio.cinecoonly.cinecoonly.servicios.ClienteServicio;
import co.edu.uniquindio.cinecoonly.cinecoonly.servicios.MailService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Component
@ViewScoped
public class RecuperarContraBean {

    @Getter
    @Setter
    @Value("${spring.mail.host}")
    private String host;

    @Getter @Setter
    @Value("${spring.mail.port}")
    private int port;

    @Getter @Setter
    @Value("${spring.mail.username}")
    private String username;

    @Getter @Setter
    @Value("${spring.mail.password}")
    private String password;

    @Getter @Setter
    private String correo;

    @Getter @Setter
    private Integer identificiacion;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private MailService correoService;

    public void enviarCorreo(){

        if(!correo.trim().equals("")&&identificiacion!=null){
            try {
                Cliente usuario = clienteServicio.recuperarContrasenia(correo, identificiacion);
                String contrasenia = usuario.getContrasenia();
                String email = usuario.getEmail();

                String mensaje = "Cinecon Only te informa\nTu contraseña es: "+contrasenia+"\nRecuerda que tu contraseña es privada y no debe ser compartida";

                correoService.sendSimpleMail(new Mail("uwu@gmail.com", email, "Recuperar Contraseña CinecoOnly", mensaje, null, null));
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Mail enviado con exito");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception e) {

                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos incorrectos");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
}
