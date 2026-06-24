package com.cine.msvc_reservas.clients;

import com.cine.msvc_reservas.dto.AsientoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MSVC-ASIENTOS", path = "/api/asientos")

public interface AsientoClient {

    @GetMapping("/{id}")
    AsientoDTO obtenerAsientoPorId(@PathVariable("id") Long id);

}
