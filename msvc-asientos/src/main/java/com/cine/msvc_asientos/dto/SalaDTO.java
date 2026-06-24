package com.cine.msvc_asientos.dto;

import lombok.Data;

@Data
public class SalaDTO {

    private Long id;
    private String nombre;
    private int capacidad;
    private String tipoPantalla;

}
