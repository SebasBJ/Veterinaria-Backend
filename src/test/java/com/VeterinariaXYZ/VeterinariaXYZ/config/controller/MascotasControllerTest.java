package com.VeterinariaXYZ.VeterinariaXYZ.config.controller;

import com.VeterinariaXYZ.VeterinariaXYZ.config.controller.errors.ApplicationCustomException;
import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import com.VeterinariaXYZ.VeterinariaXYZ.services.MascotasServiceImpl;
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

class MascotasControllerTest {

    int nmid = 1;

    int nmid_propietarios = 1;

    Mascotas mascotas;

    @InjectMocks
    private MascotasController mascotasController;

    @Mock
    private MascotasServiceImpl mascotasService;

    @Mock
    private Logger log;

    @BeforeEach
    private void init(){
        MockitoAnnotations.initMocks(this);

        if(mascotas == null){
            mascotas = new Mascotas();
        }
    }

    @Test
    void createMascotas() throws ApplicationCustomException {
        doNothing().when(log).debug("Prueba",mascotas);
        BDDMockito.given(mascotasService.save(mascotas)).willReturn(mascotas);
        ResponseEntity<ResponseMessage<Mascotas>> res = mascotasController.createMascotas(mascotas);
        assertNotNull(res);
    }

    @Test
    void updateMascotas() {
        doNothing().when(log).debug("Prueba",mascotas);
        BDDMockito.given(mascotasService.update(mascotas)).willReturn(mascotas);
        Exception res = assertThrows(ApplicationCustomException.class,()->{
            mascotasController.updateMascotas(new Mascotas());
        });
        String actualMensaje = res.getMessage();
        assertNotNull(actualMensaje);
    }

    @Test
    void getAllMascotas() {
        doNothing().when(log).debug("Prueba",mascotas);
        BDDMockito.given(mascotasService.finAll()).willReturn(Arrays.asList(mascotas));
        ResponseEntity<ResponseMessage<List<Mascotas>>> res = mascotasController.getAllMascotas();
        assertNotNull(res);
    }

    @Test
    void getMascotas() throws ApplicationCustomException{
        doNothing().when(log).debug("Prueba", nmid);
        BDDMockito.given(mascotasService.finOne(nmid)).willReturn(null);
        Exception res = assertThrows(ApplicationCustomException.class,()->{
            mascotasController.getMascotas(nmid);
        });
        String actualMensaje = res.getMessage();
        assertNotNull(actualMensaje);
    }

    @Test
    void getMascotasExcepcion() throws ApplicationCustomException{
        doNothing().when(log).debug("Prueba",mascotas);
        BDDMockito.given(mascotasService.finOne(nmid)).willReturn(mascotas);
        ResponseEntity<ResponseMessage<Mascotas>> response = mascotasController.getMascotas(nmid);
        assertNotNull(response);
    }

    @Test
    void getByIdPropietarios() {
        doNothing().when(log).debug("Prueba", nmid);
        BDDMockito.given(mascotasService.finByIdPropietario(nmid)).willReturn(null);
        Exception res = assertThrows(ApplicationCustomException.class,()->{
            mascotasController.getByIdPropietarios(nmid);
        });
        String actualMensaje = res.getMessage();
        assertNotNull(actualMensaje);
    }

    @Test
    void getByIdPropietariosExcepcion() throws ApplicationCustomException {
        doNothing().when(log).debug("Prueba",mascotas);
        BDDMockito.given(mascotasService.finByIdPropietario(nmid)).willReturn(Arrays.asList(mascotas));
        ResponseEntity<ResponseMessage<List<Mascotas>>> response = mascotasController.getByIdPropietarios(nmid_propietarios);
        assertNotNull(response);
    }
}