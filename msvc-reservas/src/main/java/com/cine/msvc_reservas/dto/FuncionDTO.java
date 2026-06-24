package com.cine.msvc_reservas.dto;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class FuncionDTO {

    private Long id;
    private LocalDateTime fechaHora;
    private double precioBase;

}
