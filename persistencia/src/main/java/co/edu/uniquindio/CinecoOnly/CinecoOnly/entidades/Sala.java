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

    private String estado;

    @OneToMany(mappedBy = "sala")
    @ToString.Exclude
    private List<Asiento> asientos;

    @OneToOne
    private Funcion funcion;

    @ManyToOne
    private Sucursal sucursal;

    public Sala(Integer codigoSala, String estado, Funcion funcion) {
        this.codigoSala = codigoSala;
        this.estado = estado;
        this.funcion = funcion;
    }
}
