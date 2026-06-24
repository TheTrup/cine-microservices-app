package com.cine.msvc_salas.dto;

public class SalaDetallesDTO {

    private Long id;
    // Agrega aquí otros atributos de tu Sala (ej. nombre, capacidad, etc.)
    private String nombre; 
    
    // ¡Aquí incrustamos el DTO de la película que trajimos con Feign!
    private PeliculaDTO pelicula;

    // Genera los Constructores, Getters y Setters
    public SalaDetallesDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public PeliculaDTO getPelicula() { return pelicula; }
    public void setPelicula(PeliculaDTO pelicula) { this.pelicula = pelicula; }
    
}
