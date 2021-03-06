package co.edu.uniquindio.cinecoonly.cinecoonly.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pelicula implements Serializable {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigoPelicula;

    @Getter @Setter
    private String nombre;

    @Future
    @Column(nullable = false)
    @ToString.Exclude
    private LocalDate fechaInicio;

    @Column(nullable = false)
    @ToString.Exclude
    private LocalDate fechaFin;

    @ToString.Exclude
    @JsonIgnore
    private String imagen;

    @ToString.Exclude
    private String descripcion;

    @OneToMany(mappedBy = "pelicula")
    @ToString.Exclude
    private List<Funcion> funciones;

    public Pelicula(Integer codigoPelicula,  String descripcion,  LocalDate fechaFin, LocalDate fechaInicio , String imagen, String nombre) {

        this.codigoPelicula = codigoPelicula;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }
}
