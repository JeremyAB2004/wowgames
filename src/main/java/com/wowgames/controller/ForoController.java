package com.wowgames.controller;

import com.wowgames.domain.Foro;
import com.wowgames.service.ForoService;
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
@RequestMapping("/foro")
public class ForoController {
    
    @Autowired
    private ForoService foroService;
    
    @GetMapping("/inicio")
    public String foroInicio(Model model) {
        var foros = foroService.getForos();
        model.addAttribute("foros", foros);
        model.addAttribute("totalForos", foros.size());
        return "/foro/inicio";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String foroGuardar(Foro foro) {        
        foroService.save(foro);
        return "redirect:/foro/inicio";
    }

    @GetMapping("/eliminar/{idForo}")
    public String foroEliminar(Foro foro) {
        foroService.delete(foro);
        return "redirect:/foro/inicio";
    }

    @GetMapping("/modificar/{idForo}")
    public String foroModificar(Foro foro, Model model) {
        foro = foroService.getForo(foro);
        model.addAttribute("foro", foro);
        return "/foro/modifica";
    }
}