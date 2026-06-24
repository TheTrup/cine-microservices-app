package com.cine.msvc_peliculas.controller;

import com.cine.msvc_peliculas.model.Pelicula;
import com.cine.msvc_peliculas.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")

public class PeliculaController {

    @Autowired
    private PeliculaService service;

    // 1. Listar todas las películas (GET)
    @GetMapping
    public List<Pelicula> listar() {
        return service.listarTodas();
    }

    // 2. Buscar una película específica por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPorId(@PathVariable Long id) {
        Optional<Pelicula> pelicula = service.buscarPorId(id);
        if (pelicula.isPresent()) {
            return ResponseEntity.ok(pelicula.get());
        }
        return ResponseEntity.notFound().build(); // Devuelve 404 si no existe
    }

    // 3. Crear una nueva película (POST)
    // El @Valid activa las validaciones que pusimos en el modelo (NotEmpty, Min)
    @PostMapping
    public ResponseEntity<Pelicula> guardar(@Valid @RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = service.guardar(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPelicula);
    }

    // 4. Eliminar una película por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Pelicula> pelicula = service.buscarPorId(id);
        if (pelicula.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 (Eliminado con éxito)
        }
        return ResponseEntity.notFound().build(); // Devuelve 404 si no existe
    }

}
