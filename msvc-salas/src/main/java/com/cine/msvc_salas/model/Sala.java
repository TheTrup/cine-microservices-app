package com.cine.msvc_salas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "salas")

public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre o número de sala es obligatorio (Ej: Sala 1)")
    private String nombre;

    @Min(value = 10, message = "La capacidad mínima es de 10 asientos")
    private int capacidad;

    @NotEmpty(message = "El tipo de pantalla es obligatorio (Ej: 2D, 3D, IMAX)")
    private String tipoPantalla;

    private Long peliculaId;

}
