package com.cine.msvc_peliculas.service;

import com.cine.msvc_peliculas.model.Pelicula;
import com.cine.msvc_peliculas.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class) // Habilita el uso de Mockito

public class PeliculaServiceTest {

    @Mock
    private PeliculaRepository repository; // Simulamos el repositorio (No toca la BD real)

    @InjectMocks
    private PeliculaService service; // Inyectamos el mock dentro de nuestro servicio real

    @Test
    void testGuardarPelicula() {
        // 1. GIVEN (Dado): Preparamos los datos de prueba
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Interstellar");
        pelicula.setDirector("Christopher Nolan");
        pelicula.setDuracionMinutos(169);
        
        Pelicula peliculaGuardada = new Pelicula();
        peliculaGuardada.setId(1L);
        peliculaGuardada.setTitulo("Interstellar");

        // Le decimos al mock: "Cuando alguien llame a save(), devuelve peliculaGuardada"
        Mockito.when(repository.save(any(Pelicula.class))).thenReturn(peliculaGuardada);

        // 2. WHEN (Cuando): Ejecutamos el método real de nuestro servicio
        Pelicula resultado = service.guardar(pelicula);

        // 3. THEN (Entonces): Verificamos que el resultado sea el esperado (Asserts)
        assertNotNull(resultado, "El resultado no debería ser nulo");
        assertEquals(1L, resultado.getId(), "El ID debería ser 1");
        assertEquals("Interstellar", resultado.getTitulo(), "El título debe coincidir");
    }

    @Test
    void testListarTodas() {
        // 1. GIVEN
        Pelicula p1 = new Pelicula();
        p1.setTitulo("Matrix");
        Pelicula p2 = new Pelicula();
        p2.setTitulo("Avatar");
        
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(p1, p2));

        // 2. WHEN
        List<Pelicula> resultado = service.listarTodas();

        // 3. THEN
        assertNotNull(resultado);
        assertEquals(2, resultado.size(), "Debería devolver 2 películas");
        assertEquals("Matrix", resultado.get(0).getTitulo());
    }
    
}
