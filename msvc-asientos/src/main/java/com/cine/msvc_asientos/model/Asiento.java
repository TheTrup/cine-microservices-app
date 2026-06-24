package com.cine.msvc_asientos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "asientos")
@Data
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String fila;  
    private Long salaId;   
    private boolean disponible;

}
