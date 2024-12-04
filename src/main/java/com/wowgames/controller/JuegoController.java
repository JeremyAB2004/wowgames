package com.wowgames.controller;

import com.wowgames.domain.Juego;
import com.wowgames.service.JuegoService;
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
@RequestMapping("/juego")
public class JuegoController {
    
    @Autowired
    private JuegoService juegoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var juegos = juegoService.getJuegos(false);
        model.addAttribute("juegos", juegos);
        model.addAttribute("totalJuegos", juegos.size());
        return "/juego/listado";
    }
    
    @GetMapping("/nuevo")
    public String juegoNuevo(Juego juego) {
        return "/juego/modifica";
    }
    
    @GetMapping("/inicio")
    public String juegoInicio(Model model) {
        var juegos = juegoService.getJuegos(false);
        model.addAttribute("juegos", juegos);
        model.addAttribute("totalJuegos", juegos.size());
        return "/juego/inicio";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String juegoGuardar(Juego juego,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            juegoService.save(juego);
            juego.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "juego", 
                            juego.getIdJuego()));
        }
        juegoService.save(juego);
        return "redirect:/juego/listado";
    }

    @GetMapping("/eliminar/{idJuego}")
    public String juegoEliminar(Juego juego) {
        juegoService.delete(juego);
        return "redirect:/juego/listado";
    }

    @GetMapping("/modificar/{idJuego}")
    public String juegoModificar(Juego juego, Model model) {
        juego = juegoService.getJuego(juego);
        model.addAttribute("juego", juego);
        return "/juego/modifica";
    }
}