package com.VeterinariaXYZ.VeterinariaXYZ.config.controller;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.EspecieMascota;
import com.VeterinariaXYZ.VeterinariaXYZ.services.EspecieMascotaServiceImpl;
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
import static org.mockito.Mockito.doNothing;

class EspecieMascotaControllerTest {

    EspecieMascota especieMascota;

    @InjectMocks
    private EspecieMascotaController especieMascotaController;

    @Mock
    private EspecieMascotaServiceImpl especieMascotaService;

    @Mock
    private Logger log;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
        if(especieMascota == null){
            especieMascota = new EspecieMascota();
        }
    }

    @Test
    void getAllEspecieMascota() {
        doNothing().when(log).debug("Prueba");
        BDDMockito.given(especieMascotaService.finAll()).willReturn(Arrays.asList(especieMascota));
        ResponseEntity<ResponseMessage<List<EspecieMascota>>> res = especieMascotaController.getAllEspecieMascota();
        assertNotNull(res);
    }
}