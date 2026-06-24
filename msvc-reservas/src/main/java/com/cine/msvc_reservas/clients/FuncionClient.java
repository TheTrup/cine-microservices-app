package com.cine.msvc_reservas.clients;

import com.cine.msvc_reservas.dto.FuncionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "MSVC-FUNCIONES", path = "/api/funciones")
public interface FuncionClient {

    @GetMapping("/{id}")
    FuncionDTO obtenerFuncionPorId(@PathVariable("id") Long id);

}
