package com.wowgames.controller;

import com.wowgames.domain.Noticia;
import com.wowgames.service.NoticiaService;
import com.wowgames.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/noticia")
public class NoticiaController {
    
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var noticias = noticiaService.getNoticias(false);
        model.addAttribute("noticias", noticias);
        model.addAttribute("totalNoticias", noticias.size());
        return "/noticia/listado";
    }
    
    @GetMapping("/nuevo")
    public String noticiaNuevo(Noticia noticia) {
        return "/noticia/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String noticiaGuardar(Noticia noticia,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            noticiaService.save(noticia);
            noticia.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "noticia", 
                            noticia.getIdNoticia()));
        }
        noticiaService.save(noticia);
        return "redirect:/noticia/listado";
    }

    @GetMapping("/eliminar/{idNoticia}")
    public String noticiaEliminar(Noticia noticia) {
        noticiaService.delete(noticia);
        return "redirect:/noticia/listado";
    }

    @GetMapping("/modificar/{idNoticia}")
    public String noticiaModificar(Noticia noticia, Model model) {
        noticia = noticiaService.getNoticia(noticia);
        model.addAttribute("noticia", noticia);
        return "/noticia/modifica";
    }
}