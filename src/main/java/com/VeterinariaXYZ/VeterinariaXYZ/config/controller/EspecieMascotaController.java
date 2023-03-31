package com.VeterinariaXYZ.VeterinariaXYZ.config.controller;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.EspecieMascota;
import com.VeterinariaXYZ.VeterinariaXYZ.services.EspecieMascotaService;
import com.VeterinariaXYZ.VeterinariaXYZ.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EspecieMascotaController {

    private Logger log = LoggerFactory.getLogger(MascotasController.class);

    private static final String ENTITY_NAME = "EspecieMascotas";

    private final EspecieMascotaService especieMascotaService;

    public EspecieMascotaController(EspecieMascotaService especieMascotaService){
        this.especieMascotaService = especieMascotaService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/especie")
    public ResponseEntity<ResponseMessage<List<EspecieMascota>>> getAllEspecieMascota(){
        log.debug("REST request to get all especie_mascotas");
        return ResponseEntity.ok( new ResponseMessage<>(0,null, especieMascotaService.finAll()));
    }
}
