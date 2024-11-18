package com.wowgames.service;

import com.wowgames.domain.Juego;
import java.util.List;

public interface JuegoService {
    
    // Se obtiene un listado de juegos en un List
    public List<Juego> getJuegos(boolean activos);
    
    // Se obtiene un Juego, a partir del id de un juego
    public Juego getJuego(Juego juego);
    
    // Se inserta un nuevo juego si el id del juego esta vacío
    // Se actualiza un juego si el id del juego NO esta vacío
    public void save(Juego juego);
    
    // Se elimina el juego que tiene el id pasado por parámetro
    public void delete(Juego juego);
 
}