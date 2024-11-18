package com.wowgames.controller;

import com.wowgames.domain.Calendario;
import com.wowgames.service.CalendarioService;
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
@RequestMapping("/calendario")
public class CalendarioController {
    
    @Autowired
    private CalendarioService calendarioService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var calendarios = calendarioService.getCalendarios(false);
        model.addAttribute("calendarios", calendarios);
        model.addAttribute("totalCalendarios", calendarios.size());
        return "/calendario/listado";
    }
    
    @GetMapping("/nuevo")
    public String calendarioNuevo(Calendario calendario) {
        return "/calendario/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String calendarioGuardar(Calendario calendario,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            calendarioService.save(calendario);
            calendario.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "calendario", 
                            calendario.getIdCalendario()));
        }
        calendarioService.save(calendario);
        return "redirect:/calendario/listado";
    }

    @GetMapping("/eliminar/{idCalendario}")
    public String calendarioEliminar(Calendario calendario) {
        calendarioService.delete(calendario);
        return "redirect:/calendario/listado";
    }

    @GetMapping("/modificar/{idCalendario}")
    public String calendarioModificar(Calendario calendario, Model model) {
        calendario = calendarioService.getCalendario(calendario);
        model.addAttribute("calendario", calendario);
        return "/calendario/modifica";
    }
}