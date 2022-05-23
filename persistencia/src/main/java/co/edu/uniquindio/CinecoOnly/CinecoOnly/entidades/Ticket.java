package co.edu.uniquindio.cinecoonly.cinecoonly.entidades;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Ticket {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer codigoTicket;

    @Column(nullable = false)
    private LocalDate fechaCompra;

    @Getter @Setter
    private String estado;

    @OneToOne
    private TipoTicket tipoTicket;

    @OneToOne
    private Asiento asiento;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcion funcion;

    public Ticket(Integer codigoTicket, LocalDate fechaCompra, String estado, TipoTicket tipoTicket, Asiento asiento, Cliente cliente, Funcion funcion) {
        this.codigoTicket = codigoTicket;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.tipoTicket = tipoTicket;
        this.asiento = asiento;
        this.cliente = cliente;
        this.funcion = funcion;
    }
}
