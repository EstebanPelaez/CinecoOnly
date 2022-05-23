package co.edu.uniquindio.cinecoonly.cinecoonly.bean;

import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Funcion;
import co.edu.uniquindio.cinecoonly.cinecoonly.entidades.Pelicula;
import co.edu.uniquindio.cinecoonly.cinecoonly.exceptions.PeliculaExistenteException;
import co.edu.uniquindio.cinecoonly.cinecoonly.servicios.FuncionServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.time.LocalDate;
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

    @Value("${upload.url}")
    private String urlUploads;

    @Getter @Setter
    private UploadedFile imagen;

    @Autowired
    private FuncionServicio funcionServicio;

    @PostConstruct
    public void inicializar(){
        Pelicula pelicula = new Pelicula();
        funcion = new Funcion();
        funcion.setPelicula(pelicula);
    }

    public void registrarFuncion(){


        try{
            funcion.getPelicula().setFechaInicio(rangoFechas.get(0).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            funcion.getPelicula().setFechaFin(rangoFechas.get(1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            funcion.setFechaFuncion(LocalDate.now());
            funcionServicio.publicarFuncion(funcion);


            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro exitoso");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        catch(PeliculaExistenteException e){
            e.getMessage();
        }

    }

    public void subirImagen(FileUploadEvent event){


        imagen=event.getFile();
        OutputStream outputStream =null;
        String enlace = urlUploads+"/"+imagen.getFileName();
        File archivo = new File(enlace);
        try{
            outputStream = new FileOutputStream(archivo);
            IOUtils.copy(imagen.getInputStream(), outputStream);
            funcion.getPelicula().setImagen(imagen.getFileName());
        }catch (Exception e){
            e.getMessage();
        }

        if(outputStream!=null){
            try {
                outputStream.close();
            } catch (IOException|NullPointerException e) {
                e.getMessage();
            }
        }
    }

}
