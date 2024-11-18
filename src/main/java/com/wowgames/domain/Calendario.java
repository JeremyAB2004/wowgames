package com.wowgames.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="calendario")
public class Calendario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_calendario")
    private Long idCalendario;
    private String titulo;
    private String descripcion;
    private String region;
    private int premio;
    private boolean estado;
    private String rutaImagen;
    private String fechaCreacion;
    private String fechaModificacion;

    public Calendario() {
    }

    public Calendario(String titulo, String descripcion, String region, int premio, boolean estado, String rutaImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.region = region;
        this.premio = premio;
        this.estado = estado;
        this.rutaImagen = rutaImagen;
    }
}