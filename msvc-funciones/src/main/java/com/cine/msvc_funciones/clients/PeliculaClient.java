package com.cine.msvc_funciones.clients;

import com.cine.msvc_funciones.dto.PeliculaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-peliculas", path = "/api/peliculas")
public interface PeliculaClient {

    @GetMapping("/{id}")
    PeliculaDTO obtenerPeliculaPorId(@PathVariable("id") Long id);

}
