package com.cine.msvc_asientos.controller;

import com.cine.msvc_asientos.dto.AsientoDetallesDTO;
import com.cine.msvc_asientos.model.Asiento;
import com.cine.msvc_asientos.service.AsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/asientos")
public class AsientoController {

    private final AsientoService service;

    public AsientoController(AsientoService service) {
        this.service = service;
    }

    @GetMapping("/sala/{salaId}")
    public List<Asiento> listarPorSala(@PathVariable Long salaId) {
        return service.listarPorSala(salaId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsientoDetallesDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerDetallesDeAsiento(id));
    }

    @PostMapping
    public ResponseEntity<Asiento> guardar(@RequestBody Asiento asiento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(asiento));
    }

}
