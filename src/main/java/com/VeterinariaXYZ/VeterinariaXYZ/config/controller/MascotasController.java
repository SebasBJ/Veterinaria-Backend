package com.VeterinariaXYZ.VeterinariaXYZ.config.controller;

import com.VeterinariaXYZ.VeterinariaXYZ.config.controller.errors.ApplicationCustomException;
import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import com.VeterinariaXYZ.VeterinariaXYZ.services.MascotasService;
import com.VeterinariaXYZ.VeterinariaXYZ.util.MessagesConstants;
import com.VeterinariaXYZ.VeterinariaXYZ.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MascotasController {

    private Logger log = LoggerFactory.getLogger(MascotasController.class);

    private static final String ENTITY_NAME = "Mascotas";

    private final MascotasService mascotasService;

    public MascotasController(MascotasService mascotasService){
        this.mascotasService = mascotasService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/mascotas")
    public ResponseEntity<ResponseMessage<Mascotas>> createMascotas(@Valid @RequestBody Mascotas mascotas) throws ApplicationCustomException {
        log.debug("REST request to save mascotas: {}", mascotas);
        Mascotas mascota = mascotasService.finOne(mascotas.getNmid());
        if (mascota != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS,ENTITY_NAME));
        }
        Mascotas result = mascotasService.save(mascotas);
        return ResponseEntity.ok(new ResponseMessage<>(0,null,result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/mascotas")
    public ResponseEntity<ResponseMessage<Mascotas>> updateMascotas(@Valid @RequestBody Mascotas mascotas) throws ApplicationCustomException {
        log.debug("REST request to update mascotas: {}", mascotas);
        if (mascotas.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Mascotas result = mascotasService.update(mascotas);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/mascotas")
    public ResponseEntity<ResponseMessage<List<Mascotas>>> getAllMascotas(){
        log.debug("REST request to get all mascotas");
        return ResponseEntity.ok( new ResponseMessage<>(0,null, mascotasService.finAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/mascotas/{nmid}")
    public ResponseEntity<ResponseMessage<Mascotas>> getMascotas(@PathVariable int nmid) throws ApplicationCustomException {
        log.debug("REST request to get mascotas: {}", nmid);
        Mascotas mascotas = mascotasService.finOne(nmid);
        if(mascotas == null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0,null, mascotas));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/mascotaspropietarios/{nmid_propietarios}")
    public ResponseEntity<ResponseMessage<List<Mascotas>>> getByIdPropietarios(@PathVariable int nmid_propietarios) throws ApplicationCustomException{
        log.debug("REST request to get all mascotas", nmid_propietarios);
        List<Mascotas> mascotasList =  mascotasService.finByIdPropietario(nmid_propietarios);
        if(mascotasList == null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok( new ResponseMessage<>(0,null, mascotasList));
    }
}
