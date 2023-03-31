package com.VeterinariaXYZ.VeterinariaXYZ.config.controller;

import com.VeterinariaXYZ.VeterinariaXYZ.config.controller.errors.ApplicationCustomException;
import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;
import com.VeterinariaXYZ.VeterinariaXYZ.services.PropietariosService;
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
public class PropietariosController {

    private Logger log = LoggerFactory.getLogger(PropietariosController.class);

    private static final String ENTITY_NAME = "Propietarios";

    private final PropietariosService propietariosService;

    public PropietariosController(PropietariosService propietariosService){
        this.propietariosService = propietariosService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/propietarios")
    public ResponseEntity<ResponseMessage<Propietarios>> createPropietarios(@Valid @RequestBody Propietarios propietarios) throws ApplicationCustomException {
        log.debug("REST request to save propietarios_mascotas: {}", propietarios);
        Propietarios propietario = propietariosService.finOne(propietarios.getNmid());
        if (propietario != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS,ENTITY_NAME));
        }
        Propietarios result = propietariosService.save(propietarios);
        return ResponseEntity.ok(new ResponseMessage<>(0,null,result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/propietarios")
    public ResponseEntity<ResponseMessage<Propietarios>> updatePropietarios(@Valid @RequestBody Propietarios propietarios) throws ApplicationCustomException {
        log.debug("REST request to update propietarios_mascotas: {}", propietarios);
        if (propietarios.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Propietarios result = propietariosService.update(propietarios);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/propietarios")
    public ResponseEntity<ResponseMessage<List<Propietarios>>> getAllPropietarios(){
        log.debug("REST request to get all propietarios_mascotas");
        return ResponseEntity.ok( new ResponseMessage<>(0,null, propietariosService.finAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/propietarios/{nmid}")
    public ResponseEntity<ResponseMessage<Propietarios>> getPropietarios(@PathVariable int nmid) throws ApplicationCustomException {
        log.debug("REST request to get propietarios_mascotas: {}", nmid);
        Propietarios propietarios = propietariosService.finOne(nmid);
        if(propietarios == null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0,null, propietarios));
    }
}
