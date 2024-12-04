package com.wowgames.service.impl;

import com.wowgames.dao.ForoDao;
import com.wowgames.domain.Foro;
import com.wowgames.service.ForoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ForoServiceImpl implements ForoService {
    
    @Autowired
    private ForoDao foroDao;

    @Override
    @Transactional(readOnly=true)
    public List<Foro> getForos() {
        var lista=foroDao.findAll();
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Foro getForo(Foro foro){
        return foroDao.findById(foro.getIdForo()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Foro foro){
        foroDao.save(foro);
    }
    
    @Override
    @Transactional
    public void delete(Foro foro){
        foroDao.delete(foro);
    }
}