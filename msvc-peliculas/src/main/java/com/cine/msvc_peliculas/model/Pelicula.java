package com.cine.msvc_peliculas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data // Magia de Lombok: crea los getters, setters y constructores automáticamente
@Entity
@Table(name = "peliculas")

public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El título de la película no puede estar vacío")
    private String titulo;

    @NotEmpty(message = "El director no puede estar vacío")
    private String director;

    @NotEmpty(message = "La sinopsis no puede estar vacía")
    @Column(length = 1000) // Para que el texto pueda ser largo
    private String sinopsis;

    @Min(value = 1, message = "La duración debe ser mayor a 0 minutos")
    private int duracionMinutos;

    @NotEmpty(message = "La clasificación por edad es obligatoria (Ej: TE, +14, +18)")
    private String clasificacion;

}
