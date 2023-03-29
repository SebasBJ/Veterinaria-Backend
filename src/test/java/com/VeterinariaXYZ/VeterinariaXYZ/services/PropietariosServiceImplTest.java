package com.VeterinariaXYZ.VeterinariaXYZ.services;

import com.VeterinariaXYZ.VeterinariaXYZ.dao.PropietariosDAO;
import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class PropietariosServiceImplTest {
    Propietarios propietarios;

    @Spy
    @InjectMocks
    private PropietariosServiceImpl propietariosService;

    @Mock
    private PropietariosDAO propietariosDAO;

    @Mock
    private Logger log;

    @BeforeEach
    public void init() throws IOException {
        MockitoAnnotations.initMocks(this);

        if(propietariosService == null){
            propietariosService = new PropietariosServiceImpl(propietariosDAO);
        }

        if(propietarios == null){
            propietarios = new Propietarios();
            propietarios.setNmid(1);
            propietarios.setDsnombre_completo("Sebastian");
            propietarios.setDstipo_documento("C.C");
            propietarios.setNmidentificacion(1234567897);
            propietarios.setDsciudad("Medellin");
            propietarios.setDsdireccion("Calle 97B #23B-21");
            propietarios.setNmtelefono(12345678);
            propietarios.setDtfecha_registro(LocalDate.EPOCH);
        }
    }

    @Test
    void save() {
        doNothing().when(log).debug("Prueba",propietarios);
        when(propietariosDAO.insert(propietarios)).thenReturn(propietarios);
        assertNotNull(propietariosService.save(propietarios));
    }

    @Test
    void update() {
        doNothing().when(log).debug("Prueba", propietarios);
        when(propietariosDAO.update(propietarios)).thenReturn(propietarios);
        assertNotNull(propietariosService.update(propietarios));
    }

    @Test
    void finAll() {
        doNothing().when(log).debug("Prueba");
        when(propietariosDAO.getAll()).thenReturn(Arrays.asList(propietarios));
        assertNotNull(propietariosService.finAll());
    }

    @Test
    void finOne() {
        doNothing().when(log).debug("Prueba");
        when(propietariosDAO.getById(1)).thenReturn(propietarios);
        assertNotNull(propietariosService.finOne(1));
    }
}