package com.cine.msvc_funciones.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "funciones")
@Data
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long peliculaId;
    private Long salaId;
    private LocalDateTime fechaHora;
    private double precioBase;
}