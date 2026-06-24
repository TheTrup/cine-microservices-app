package com.cine.msvc_funciones.clients;

import com.cine.msvc_funciones.dto.SalaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "msvc-salas", path = "/api/salas")
public interface SalaClient {

    @GetMapping("/{id}")
    SalaDTO obtenerSalaPorId(@PathVariable("id") Long id);

}
