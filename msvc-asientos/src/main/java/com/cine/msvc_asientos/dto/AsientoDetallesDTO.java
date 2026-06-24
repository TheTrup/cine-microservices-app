package com.cine.msvc_asientos.dto;

import lombok.Data;

@Data
public class AsientoDetallesDTO {

    private Long id;
    private String numero;
    private String fila;
    private boolean disponible;
    private SalaDTO sala; // Aquí inyectamos los detalles remotos de la sala

}
