package co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Sucursal {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigoSucursal;

    @Column(nullable = false, length = 80)
    @Length(max = 80)
    private String nombre;

    @Column(nullable = false, length = 80, unique = true)
    @Length(max = 80)
    private String direccion;

    private String estado;

    @ManyToOne
    private Ciudad ubicacion;

    @OneToMany(mappedBy = "sucursal")
    @ToString.Exclude
    private List<Sala> salas;

    public Sucursal(Integer codigoSucursal, String nombre, String direccion, String estado) {

        this.codigoSucursal = codigoSucursal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
    }
}
