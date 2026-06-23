package com.cine.msvc_sucursales.service;

import com.cine.msvc_sucursales.model.Sucursal;
import com.cine.msvc_sucursales.repository.SucursalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class SucursalService {

    private final SucursalRepository repository;

    public SucursalService(SucursalRepository repository) {
        this.repository = repository;
    }

    public List<Sucursal> listarTodas() {
        return repository.findAll();
    }

    public Optional<Sucursal> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Sucursal guardar(Sucursal sucursal) {
        return repository.save(sucursal);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
