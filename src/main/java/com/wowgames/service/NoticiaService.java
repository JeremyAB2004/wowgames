package com.wowgames.service;

import com.wowgames.domain.Noticia;
import java.util.List;

public interface NoticiaService {
    
    // Se obtiene un listado de noticias en un List
    public List<Noticia> getNoticias(boolean activos);
    
    // Se obtiene un Noticia, a partir del id de un noticia
    public Noticia getNoticia(Noticia noticia);
    
    // Se inserta un nuevo noticia si el id del noticia esta vacío
    // Se actualiza un noticia si el id del noticia NO esta vacío
    public void save(Noticia noticia);
    
    // Se elimina el noticia que tiene el id pasado por parámetro
    public void delete(Noticia noticia);
 
}