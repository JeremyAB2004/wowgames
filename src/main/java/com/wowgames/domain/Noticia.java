package com.wowgames.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="noticia")
public class Noticia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id_noticia")
    private Long idNoticia;
    private String titulo;
    private String descripcion;
    private boolean estado;
    private String rutaImagen;
    private String fechaCreacion;
    private String fechaModificacion;

    public Noticia() {
    }

    public Noticia(String titulo, String descripcion, boolean estado, String rutaImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.rutaImagen = rutaImagen;
    }
}