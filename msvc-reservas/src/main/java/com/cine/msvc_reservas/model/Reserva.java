package com.cine.msvc_reservas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Entity
@Table(name = "reservas")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuarioId;
    private Long funcionId;
    private Long asientoId;
    private LocalDateTime fechaReserva;
    private double totalPagar;

}
