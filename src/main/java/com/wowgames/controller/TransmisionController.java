package com.wowgames.controller;

import com.wowgames.domain.Transmision;
import com.wowgames.service.TransmisionService;
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
@RequestMapping("/transmision")
public class TransmisionController {
    
    @Autowired
    private TransmisionService transmisionService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var transmisiones = transmisionService.getTransmisiones(false);
        model.addAttribute("transmisiones", transmisiones);
        model.addAttribute("totalTransmisiones", transmisiones.size());
        return "/transmision/listado";
    }
    
    @GetMapping("/nuevo")
    public String transmisionNuevo(Transmision transmision) {
        return "/transmision/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String transmisionGuardar(Transmision transmision,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            transmisionService.save(transmision);
            transmision.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "transmision", 
                            transmision.getIdTransmision()));
        }
        transmisionService.save(transmision);
        return "redirect:/transmision/listado";
    }

    @GetMapping("/eliminar/{idTransmision}")
    public String transmisionEliminar(Transmision transmision) {
        transmisionService.delete(transmision);
        return "redirect:/transmision/listado";
    }

    @GetMapping("/modificar/{idTransmision}")
    public String transmisionModificar(Transmision transmision, Model model) {
        transmision = transmisionService.getTransmision(transmision);
        model.addAttribute("transmision", transmision);
        return "/transmision/modifica";
    }
}