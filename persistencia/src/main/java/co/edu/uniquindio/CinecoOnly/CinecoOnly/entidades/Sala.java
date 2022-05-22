package co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Sala {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigoSala;

    @Getter @Setter
    private String estado;

    @OneToMany(mappedBy = "sala")
    @ToString.Exclude
    private List<Asiento> asientos;

    @OneToOne
    private Funcion funcion;

    @ManyToOne
    private Sucursal sucursal;



}
