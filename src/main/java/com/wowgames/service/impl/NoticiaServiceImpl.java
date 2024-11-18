package com.wowgames.service.impl;

import com.wowgames.dao.NoticiaDao;
import com.wowgames.domain.Noticia;
import com.wowgames.service.NoticiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticiaServiceImpl implements NoticiaService {
    
    @Autowired
    private NoticiaDao noticiaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Noticia> getNoticias(boolean activos) {
        var lista=noticiaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isEstado());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Noticia getNoticia(Noticia noticia){
        return noticiaDao.findById(noticia.getIdNoticia()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Noticia noticia){
        noticiaDao.save(noticia);
    }
    
    @Override
    @Transactional
    public void delete(Noticia noticia){
        noticiaDao.delete(noticia);
    }
}