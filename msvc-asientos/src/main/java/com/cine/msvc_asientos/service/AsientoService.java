package com.cine.msvc_asientos.service;

import com.cine.msvc_asientos.clients.SalaClient;
import com.cine.msvc_asientos.dto.AsientoDetallesDTO;
import com.cine.msvc_asientos.dto.SalaDTO;
import com.cine.msvc_asientos.model.Asiento;
import com.cine.msvc_asientos.repository.AsientoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsientoService {

    private final AsientoRepository repository;
    private final SalaClient salaClient;

    public AsientoService(AsientoRepository repository, SalaClient salaClient) {
        this.repository = repository;
        this.salaClient = salaClient;
    }

    public List<Asiento> listarPorSala(Long salaId) {
        return repository.findBySalaId(salaId);
    }

    public Asiento guardar(Asiento asiento) {
        return repository.save(asiento);
    }

    public AsientoDetallesDTO obtenerDetallesDeAsiento(Long id) {
        Asiento asiento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));

        // Llamada remota via Feign
        SalaDTO sala = salaClient.obtenerSalaPorId(asiento.getSalaId());

        AsientoDetallesDTO detalles = new AsientoDetallesDTO();
        detalles.setId(asiento.getId());
        detalles.setNumero(asiento.getNumero());
        detalles.setFila(asiento.getFila());
        detalles.setDisponible(asiento.isDisponible());
        detalles.setSala(sala);

        return detalles;
    }
}
