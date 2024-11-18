package com.wowgames.dao;

import com.wowgames.domain.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioDao extends JpaRepository <Calendario,Long> {
    
}