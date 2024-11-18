package com.wowgames.dao;

import com.wowgames.domain.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaDao extends JpaRepository <Noticia,Long> {
    
}