package com.wowgames.service;

import com.wowgames.domain.Calendario;
import java.util.List;

public interface CalendarioService {
    
    // Se obtiene un listado de calendarios en un List
    public List<Calendario> getCalendarios(boolean activos);
    
    // Se obtiene un Calendario, a partir del id de un calendario
    public Calendario getCalendario(Calendario calendario);
    
    // Se inserta un nuevo calendario si el id del calendario esta vacío
    // Se actualiza un calendario si el id del calendario NO esta vacío
    public void save(Calendario calendario);
    
    // Se elimina el calendario que tiene el id pasado por parámetro
    public void delete(Calendario calendario);
 
}