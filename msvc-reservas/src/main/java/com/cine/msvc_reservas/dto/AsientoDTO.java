package com.cine.msvc_reservas.dto;

import lombok.Data;

@Data
public class AsientoDTO {

    private Long id;
    private String numero;
    private String fila;
    private boolean disponible;

}
