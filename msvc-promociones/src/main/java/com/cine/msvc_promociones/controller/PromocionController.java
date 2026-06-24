package com.cine.msvc_promociones.controller;

import com.cine.msvc_promociones.model.Promocion;
import com.cine.msvc_promociones.service.PromocionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/promociones")

public class PromocionController {

    private final PromocionService service;

    // Línea 17 corregida:
    public PromocionController(PromocionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Promocion> listar() {
        return service.listarTodas();
    }

    @GetMapping("/validar/{codigo}")
    public ResponseEntity<Promocion> validarCodigo(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Promocion> crear(@RequestBody Promocion promocion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(promocion));
    }

}
