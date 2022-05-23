package co.edu.uniquindio.CinecoOnly.CinecoOnly.entidades;

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

    private String estado;

    @OneToOne
    private Tipo_Ticket tipoTicket;

    @OneToOne
    private Asiento asiento;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcion funcion;



}
