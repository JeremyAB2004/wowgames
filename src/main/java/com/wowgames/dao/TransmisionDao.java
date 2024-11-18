package com.wowgames.dao;

import com.wowgames.domain.Transmision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmisionDao extends JpaRepository <Transmision,Long> {
    
}