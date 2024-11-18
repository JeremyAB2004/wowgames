package com.wowgames.dao;

import com.wowgames.domain.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoDao extends JpaRepository <Juego,Long> {
    
}