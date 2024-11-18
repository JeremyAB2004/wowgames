package com.wowgames.service.impl;

import com.wowgames.dao.JuegoDao;
import com.wowgames.domain.Juego;
import com.wowgames.service.JuegoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JuegoServiceImpl implements JuegoService {
    
    @Autowired
    private JuegoDao juegoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Juego> getJuegos(boolean activos) {
        var lista=juegoDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isEstado());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Juego getJuego(Juego juego){
        return juegoDao.findById(juego.getIdJuego()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Juego juego){
        juegoDao.save(juego);
    }
    
    @Override
    @Transactional
    public void delete(Juego juego){
        juegoDao.delete(juego);
    }
}