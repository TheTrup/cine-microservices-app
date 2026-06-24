package com.cine.msvc_reservas.controller;

import com.cine.msvc_reservas.dto.ReservaDetallesDTO;
import com.cine.msvc_reservas.model.Reserva;
import com.cine.msvc_reservas.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDetallesDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerDetallesDeReserva(id));
    }

    @PostMapping
    public ResponseEntity<Reserva> crear(@RequestBody Reserva reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(reserva));
    }

}
