package com.cine.msvc_comentarios.controller;

import com.cine.msvc_comentarios.model.Comentario;
import com.cine.msvc_comentarios.service.ComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comentarios")

public class ComentarioController {

    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    @GetMapping("/pelicula/{peliculaId}")
    public List<Comentario> listarPorPelicula(@PathVariable Long peliculaId) {
        return service.listarPorPelicula(peliculaId);
    }

    @PostMapping
    public ResponseEntity<Comentario> crear(@RequestBody Comentario comentario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(comentario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
