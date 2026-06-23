package com.cine.msvc_comentarios.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Data


public class Comentario {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long peliculaId;  // Enlace lógico con msvc-peliculas
    private Long usuarioId;   // Enlace lógico con msvc-usuarios
    private String texto;
    private int calificacion; // Escala del 1 al 5
    private LocalDateTime fechaCreacion;

}
