package com.wowgames.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="transmision")
public class Transmision implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_transmision")
    private Long idTransmision;
    private String titulo;
    private String link;
    private boolean estado;
    private String rutaImagen;
    private String fechaCreacion;
    private String fechaModificacion;

    public Transmision() {
    }

    public Transmision(String titulo, String link, boolean estado, String rutaImagen) {
        this.titulo = titulo;
        this.link = link;
        this.estado = estado;
        this.rutaImagen = rutaImagen;
    }
}