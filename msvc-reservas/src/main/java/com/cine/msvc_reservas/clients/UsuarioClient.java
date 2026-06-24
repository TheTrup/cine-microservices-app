package com.cine.msvc_reservas.clients;

import com.cine.msvc_reservas.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MSVC-USUARIOS", path = "/api/usuarios")
public interface UsuarioClient {
    @GetMapping("/{id}")
    UsuarioDTO obtenerUsuarioPorId(@PathVariable("id") Long id);

}
