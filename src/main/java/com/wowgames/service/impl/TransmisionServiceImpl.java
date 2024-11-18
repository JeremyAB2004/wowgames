package com.wowgames.service.impl;

import com.wowgames.dao.TransmisionDao;
import com.wowgames.domain.Transmision;
import com.wowgames.service.TransmisionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransmisionServiceImpl implements TransmisionService {
    
    @Autowired
    private TransmisionDao transmisionDao;

    @Override
    @Transactional(readOnly=true)
    public List<Transmision> getTransmisiones(boolean activos) {
        var lista=transmisionDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isEstado());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Transmision getTransmision(Transmision transmision){
        return transmisionDao.findById(transmision.getIdTransmision()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Transmision transmision){
        transmisionDao.save(transmision);
    }
    
    @Override
    @Transactional
    public void delete(Transmision transmision){
        transmisionDao.delete(transmision);
    }
}