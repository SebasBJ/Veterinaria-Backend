package com.VeterinariaXYZ.VeterinariaXYZ.config.controller;

import com.VeterinariaXYZ.VeterinariaXYZ.config.controller.errors.ApplicationCustomException;
import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;
import com.VeterinariaXYZ.VeterinariaXYZ.services.PropietariosServiceImpl;
import com.VeterinariaXYZ.VeterinariaXYZ.util.ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;

public class PropietariosControllerTest{
    int nmid = 1;

    Propietarios propietarios;

    @InjectMocks
    private PropietariosController propietariosController;

    @Mock
    private PropietariosServiceImpl propietariosService;

    @Mock
    private Logger log;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        if(propietarios == null){
            propietarios = new Propietarios();
        }
    }

    @Test
    void createPropietarios() throws ApplicationCustomException {
        doNothing().when(log).debug("Prueba",propietarios);
        BDDMockito.given(propietariosService.save(propietarios)).willReturn(propietarios);
        ResponseEntity<ResponseMessage<Propietarios>> res = propietariosController.createPropietarios(propietarios);
        assertNotNull(res);
    }

    @Test
    void updatePropietarios() throws ApplicationCustomException {
        doNothing().when(log).debug("Prueba",propietarios);
        BDDMockito.given(propietariosService.update(propietarios)).willReturn(propietarios);
        Exception res = assertThrows(ApplicationCustomException.class,()->{
            propietariosController.updatePropietarios(new Propietarios());
        });
        String actualMensaje = res.getMessage();
        assertNotNull(actualMensaje);
    }

    @Test
    void getAllPropietarios() {
        doNothing().when(log).debug("Prueba",propietarios);
        BDDMockito.given(propietariosService.finAll()).willReturn(Arrays.asList(propietarios));
        ResponseEntity<ResponseMessage<List<Propietarios>>> res = propietariosController.getAllPropietarios();
        assertNotNull(res);
    }

    @Test
    void getPropietarios() throws ApplicationCustomException{
        doNothing().when(log).debug("Prueba", nmid);
        BDDMockito.given(propietariosService.finOne(nmid)).willReturn(null);
        Exception res = assertThrows(ApplicationCustomException.class,()->{
            propietariosController.getPropietarios(nmid);
        });
        String actualMensaje = res.getMessage();
        assertNotNull(actualMensaje);
    }

    @Test
    void getPropietariosExcepcion() throws ApplicationCustomException{
        doNothing().when(log).debug("Prueba",propietarios);
        BDDMockito.given(propietariosService.finOne(nmid)).willReturn(propietarios);
        ResponseEntity<ResponseMessage<Propietarios>> response = propietariosController.getPropietarios(nmid);
        assertNotNull(response);
    }

}