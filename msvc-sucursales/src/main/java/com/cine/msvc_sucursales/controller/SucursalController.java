package com.cine.msvc_sucursales.controller;

import com.cine.msvc_sucursales.model.Sucursal;
import com.cine.msvc_sucursales.service.SucursalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sucursales")

public class SucursalController {

    private final SucursalService service;

    public SucursalController(SucursalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sucursal> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sucursal> crear(@RequestBody Sucursal sucursal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(sucursal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
