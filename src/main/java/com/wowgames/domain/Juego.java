package com.wowgames.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="juego")
public class Juego implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_juego")
    private Long idJuego;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private String rutaImagen;
    private String fechaCreacion;
    private String fechaModificacion;

    public Juego() {
    }

    public Juego(String nombre, String descripcion, boolean estado, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.rutaImagen = rutaImagen;
    }
}