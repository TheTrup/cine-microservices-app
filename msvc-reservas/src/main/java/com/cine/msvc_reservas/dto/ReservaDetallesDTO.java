package com.cine.msvc_reservas.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReservaDetallesDTO {

    private Long id;
    private LocalDateTime fechaReserva;
    private double totalPagar;
    private UsuarioDTO usuario;
    private FuncionDTO funcion;
    private AsientoDTO asiento;

}
