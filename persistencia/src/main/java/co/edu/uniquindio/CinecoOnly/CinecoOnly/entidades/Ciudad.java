package co.edu.uniquindio.cinecoonly.cinecoonly.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCiudad;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "ubicacion")
    @ToString.Exclude
    private List<Sucursal> sucursal;

    public Ciudad(Integer codigoCiudad, String nombre) {
        this.codigoCiudad = codigoCiudad;
        this.nombre = nombre;
    }
}
