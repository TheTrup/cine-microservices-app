package com.cine.msvc_historial.controller;

import com.cine.msvc_historial.model.Historial;
import com.cine.msvc_historial.service.HistorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historial")

public class HistorialController {

    private final HistorialService service;

    public HistorialController(HistorialService service) {
        this.service = service;
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Historial> obtenerHistorialPorUsuario(@PathVariable Long usuarioId) {
        return service.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public ResponseEntity<Historial> crear(@RequestBody Historial historial) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarEnHistorial(historial));
    }

}
