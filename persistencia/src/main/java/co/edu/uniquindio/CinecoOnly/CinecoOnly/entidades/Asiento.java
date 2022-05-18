package co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Asiento {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigoAsiento;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String letra;

    private String estado;

    @ManyToOne
    private Sala sala;

    @OneToOne
    private Ticket ticket;

}
