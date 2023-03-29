package com.VeterinariaXYZ.VeterinariaXYZ.services;

import com.VeterinariaXYZ.VeterinariaXYZ.dao.MascotasDAO;
import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class MascotasServiceImplTest {

    Mascotas mascotas;

    @Spy
    @InjectMocks
    private MascotasServiceImpl mascotasService;

    @Mock
    private MascotasDAO mascotasDAO;

    @Mock
    private Logger log;

    @BeforeEach
    public void init() throws IOException {
        MockitoAnnotations.initMocks(this);

        if(mascotasService == null){
            mascotasService = new MascotasServiceImpl(mascotasDAO);
        }

        if(mascotas == null){
            mascotas = new Mascotas();
            mascotas.setNmid(1);
            mascotas.setDsnombre_mascota("Lupita");
            mascotas.setDsraza("Labrador");
            mascotas.setDtfecha_nacimiento(Date.valueOf("2023-05-06").toLocalDate());
            mascotas.setNmid_propietarios(1);
            mascotas.setNmid_especie(1);
        }
    }

    @Test
    void save() {
        doNothing().when(log).debug("Prueba", mascotas);
        when(mascotasDAO.insert(mascotas)).thenReturn(mascotas);
        assertNotNull(mascotasService.save(mascotas));
    }

    @Test
    void update() {
        doNothing().when(log).debug("Prueba", mascotas);
        when(mascotasDAO.update(mascotas)).thenReturn(mascotas);
        assertNotNull(mascotasService.update(mascotas));
    }

    @Test
    void finAll() {
        doNothing().when(log).debug("Prueba");
        when(mascotasDAO.getAll()).thenReturn(Arrays.asList(mascotas));
        assertNotNull(mascotasService.finAll());
    }

    @Test
    void finOne() {
        doNothing().when(log).debug("Prueba");
        when(mascotasDAO.getById(1)).thenReturn(mascotas);
        assertNotNull(mascotasService.finOne(1));
    }

    @Test
    void finByIdPropietario() {
        doNothing().when(log).debug("Prueba");
        when(mascotasDAO.getAll()).thenReturn(Arrays.asList(mascotas));
        assertNotNull(mascotasService.finByIdPropietario(1));
    }
}