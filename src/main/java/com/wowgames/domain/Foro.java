package com.wowgames.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="foro")
public class Foro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_foro")
    private Long idForo;
    private String titulo;
    private String descripcion;
    private boolean estado;

    public Foro() {
    }

    public Foro(String nombre, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}