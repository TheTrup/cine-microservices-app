package com.cine.msvc_funciones.controller;

import com.cine.msvc_funciones.dto.FuncionDetallesDTO;
import com.cine.msvc_funciones.model.Funcion;
import com.cine.msvc_funciones.service.FuncionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funciones")
public class FuncionController {

    private final FuncionService service;

    public FuncionController(FuncionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Funcion> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionDetallesDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerDetallesDeFuncion(id));
    }

    @PostMapping
    public ResponseEntity<Funcion> guardar(@RequestBody Funcion funcion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(funcion));
    }
    
}
