package com.cine.msvc_promociones.service;

import com.cine.msvc_promociones.model.Promocion;
import com.cine.msvc_promociones.repository.PromocionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class PromocionService {

    private final PromocionRepository repository;

    public PromocionService(PromocionRepository repository) {
        this.repository = repository;
    }

    public List<Promocion> listarTodas() {
        return repository.findAll();
    }

    public Optional<Promocion> buscarPorCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

    public Promocion guardar(Promocion promocion) {
        return repository.save(promocion);
    }

}
