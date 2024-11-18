package com.wowgames.service;

import com.wowgames.domain.Transmision;
import java.util.List;

public interface TransmisionService {
    
    // Se obtiene un listado de transmisions en un List
    public List<Transmision> getTransmisiones(boolean activos);
    
    // Se obtiene un Transmision, a partir del id de un transmision
    public Transmision getTransmision(Transmision transmision);
    
    // Se inserta un nuevo transmision si el id del transmision esta vacío
    // Se actualiza un transmision si el id del transmision NO esta vacío
    public void save(Transmision transmision);
    
    // Se elimina el transmision que tiene el id pasado por parámetro
    public void delete(Transmision transmision);
 
}