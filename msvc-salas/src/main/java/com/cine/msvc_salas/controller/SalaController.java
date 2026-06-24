package com.cine.msvc_salas.controller;

import com.cine.msvc_salas.dto.SalaDetallesDTO;
import com.cine.msvc_salas.model.Sala;
import com.cine.msvc_salas.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    // 1. Ya no inyectamos PeliculaClient, solo el Servicio
    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sala> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDetallesDTO> obtenerSalaConSuPelicula(@PathVariable Long id) {
        SalaDetallesDTO detalles = service.obtenerDetallesDeSala(id);
        return ResponseEntity.ok(detalles);
    }

    @PostMapping
    public ResponseEntity<Sala> guardar(@Valid @RequestBody Sala sala) {
        Sala nuevaSala = service.guardar(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSala);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Sala> sala = service.buscarPorId(id);
        if (sala.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}