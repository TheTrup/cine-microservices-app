package com.cine.msvc_asientos.clients;

import com.cine.msvc_asientos.dto.SalaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "MSVC-SALAS", path = "/api/salas")
public interface SalaClient {

    @GetMapping("/{id}")
    SalaDTO obtenerSalaPorId(@PathVariable("id") Long id);

}
