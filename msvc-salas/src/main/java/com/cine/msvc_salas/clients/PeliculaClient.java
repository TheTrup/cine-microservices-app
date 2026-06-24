package com.cine.msvc_salas.clients;

import com.cine.msvc_salas.dto.PeliculaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "msvc-peliculas")
public interface PeliculaClient {

    @GetMapping("/api/peliculas/{id}")
    PeliculaDTO obtenerPeliculaPorId(@PathVariable("id") Long id);
}
