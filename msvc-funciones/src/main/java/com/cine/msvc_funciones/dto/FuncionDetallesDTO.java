package com.cine.msvc_funciones.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FuncionDetallesDTO {

    private Long id;
    private LocalDateTime fechaHora;
    private double precioBase;
    private PeliculaDTO pelicula;
    private SalaDTO sala;
    
}
