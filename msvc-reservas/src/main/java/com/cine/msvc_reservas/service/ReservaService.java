package com.cine.msvc_reservas.service;


import com.cine.msvc_reservas.clients.AsientoClient;
import com.cine.msvc_reservas.clients.FuncionClient;
import com.cine.msvc_reservas.clients.UsuarioClient;
import com.cine.msvc_reservas.dto.*;
import com.cine.msvc_reservas.model.Reserva;
import com.cine.msvc_reservas.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ReservaService {

    private final ReservaRepository repository;
    private final UsuarioClient usuarioClient;
    private final FuncionClient funcionClient;
    private final AsientoClient asientoClient;

    public ReservaService(ReservaRepository repository, UsuarioClient usuarioClient, 
                          FuncionClient funcionClient, AsientoClient asientoClient) {
        this.repository = repository;
        this.usuarioClient = usuarioClient;
        this.funcionClient = funcionClient;
        this.asientoClient = asientoClient;
    }

    public Reserva guardar(Reserva reserva) {
        reserva.setFechaReserva(LocalDateTime.now());
        // Traemos la función remota para cobrar el precio base exacto automáticamente
        FuncionDTO funcion = funcionClient.obtenerFuncionPorId(reserva.getFuncionId());
        reserva.setTotalPagar(funcion.getPrecioBase());
        
        return repository.save(reserva);
    }

    public ReservaDetallesDTO obtenerDetallesDeReserva(Long id) {
        Reserva reserva = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        // Triple llamada remota en paralelo a través de Eureka
        UsuarioDTO usuario = usuarioClient.obtenerUsuarioPorId(reserva.getUsuarioId());
        FuncionDTO funcion = funcionClient.obtenerFuncionPorId(reserva.getFuncionId());
        AsientoDTO asiento = asientoClient.obtenerAsientoPorId(reserva.getAsientoId());

        ReservaDetallesDTO detalles = new ReservaDetallesDTO();
        detalles.setId(reserva.getId());
        detalles.setFechaReserva(reserva.getFechaReserva());
        detalles.setTotalPagar(reserva.getTotalPagar());
        detalles.setUsuario(usuario);
        detalles.setFuncion(funcion);
        detalles.setAsiento(asiento);

        return detalles;
    }

}
