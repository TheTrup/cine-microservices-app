package com.cine.msvc_historial.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "historiales")
@Data

public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuarioId;   // Relación lógica con msvc-usuarios
    private Long reservaId;   // Relación lógica con msvc-reservas
    private String estadoPago; // Ejemplo: "COMPLETADO", "RECHAZADO"
    private LocalDateTime fechaFinalizacion;

}
