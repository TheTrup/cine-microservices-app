package com.cine.msvc_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder) {
        return builder.routes()
            // Ruta hacia Películas
            .route("route-peliculas", r -> r.path("/api/peliculas", "/api/peliculas/**")
                .uri("lb://MSVC-PELICULAS"))
            
            // Ruta hacia Salas
            .route("route-salas", r -> r.path("/api/salas", "/api/salas/**")
                .uri("lb://MSVC-SALAS"))

            // Ruta hacia Funciones
            .route("route-funciones", r -> r.path("/api/funciones", "/api/funciones/**")
                .uri("lb://MSVC-FUNCIONES"))

            // Ruta hacia Asientos 
            .route("route-asientos", r -> r.path("/api/asientos", "/api/asientos/**")
                .uri("lb://MSVC-ASIENTOS"))

            // Ruta hacia Usuarios 
            .route("route-usuarios", r -> r.path("/api/usuarios", "/api/usuarios/**")
                .uri("lb://MSVC-USUARIOS"))

            // Ruta hacia Sucursales 
            .route("route-sucursales", r -> r.path("/api/sucursales", "/api/sucursales/**")
                .uri("lb://MSVC-SUCURSALES"))

            // Ruta hacia Reservas 
            .route("route-reservas", r -> r.path("/api/reservas", "/api/reservas/**")
                .uri("lb://MSVC-RESERVAS"))

            // Ruta hacia Comentarios 
            .route("route-comentarios", r -> r.path("/api/comentarios", "/api/comentarios/**")
                .uri("lb://MSVC-COMENTARIOS"))

            // Ruta hacia Promociones 
            .route("route-promociones", r -> r.path("/api/promociones", "/api/promociones/**")
                .uri("lb://MSVC-PROMOCIONES"))

            // Ruta hacia Historial 
            .route("route-historial", r -> r.path("/api/historial", "/api/historial/**")
                .uri("lb://MSVC-HISTORIAL"))
            
            .build();
    }
    
}
