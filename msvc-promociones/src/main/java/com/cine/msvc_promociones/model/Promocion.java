package com.cine.msvc_promociones.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "promociones")
@Data

public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;        // Ejemplo: "DESCUENTO20"
    private double porcentaje;    // Ejemplo: 20.0 (para un 20% de descuento)
    private boolean activa;

}
