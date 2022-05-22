package co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cliente {

    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 80)
    @Length(max = 80)
    private String nombre;

    @Column(nullable = false, unique = true, length = 120)
    @Length(max = 120)
    @Email(message = "Por favor ingrese un email válido.")
    private String email;

    @Column(nullable = false, length = 80)
    @Length(max = 80,min = 6, message = "Longitud no válida para la contraseña")
    private String contrasenia;

    @Getter @Setter
    private String estado;

    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private List<Ticket> tiquetes;

    public Cliente(Integer codigo, String nombre, String email, String contrasenia, String estado){

        this.codigo=codigo;
        this.nombre=nombre;
        this.email=email;
        this.contrasenia=contrasenia;
        this.estado=estado;
        this.tiquetes = new ArrayList<>();
    }
}
