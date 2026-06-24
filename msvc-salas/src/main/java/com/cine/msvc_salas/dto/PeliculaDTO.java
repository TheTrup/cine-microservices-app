package com.cine.msvc_salas.dto;

import lombok.Data;

@Data // 
public class PeliculaDTO {
    private Long id;
    private String titulo;
    private String director;
    private String clasificacion;
    private int duracionMinutos;
    private String sinopsis; 
}