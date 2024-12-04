package com.wowgames.dao;

import com.wowgames.domain.Foro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForoDao extends JpaRepository <Foro,Long> {
    
}