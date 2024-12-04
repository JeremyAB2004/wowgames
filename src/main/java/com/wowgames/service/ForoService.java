package com.wowgames.service;

import com.wowgames.domain.Foro;
import java.util.List;

public interface ForoService {
    
    // Se obtiene un listado de foros en un List
    public List<Foro> getForos();
    
    // Se obtiene un Foro, a partir del id de un foro
    public Foro getForo(Foro foro);
    
    // Se inserta un nuevo foro si el id del foro esta vacío
    // Se actualiza un foro si el id del foro NO esta vacío
    public void save(Foro foro);
    
    // Se elimina el foro que tiene el id pasado por parámetro
    public void delete(Foro foro);
 
}