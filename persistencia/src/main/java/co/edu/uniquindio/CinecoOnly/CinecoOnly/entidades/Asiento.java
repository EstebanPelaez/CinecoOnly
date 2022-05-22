package co.edu.uniquindio.cinecoonly.cinecoonly.entidades;

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

    @Getter @Setter
    private String estado;

    @ManyToOne
    private Sala sala;

    @OneToOne
    private Ticket ticket;

}
