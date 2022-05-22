package co.edu.uniquindio.cinecoonly.cinecoonly.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Funcion {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigoFuncion;

    @Future
    @Column(nullable = false)
    private LocalDate fechaFuncion;

    @ElementCollection()
    @ToString.Exclude
    @JsonIgnore
    private List<String> horarios;

    @OneToMany(mappedBy = "funcion")
    @ToString.Exclude
    private List<Ticket> tiquetes;

    @ManyToOne
    private Pelicula pelicula;

    @OneToOne
    private Sala sala;

    @Getter @Setter
    private String estado;
}
