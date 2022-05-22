package co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TipoTicket {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigoTipoTicket;

    @OneToOne
    private Ticket tiquete;
}
