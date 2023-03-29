package com.VeterinariaXYZ.VeterinariaXYZ.dao;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import com.VeterinariaXYZ.VeterinariaXYZ.mapper.MascotasMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MascotasDAOImplTest {

    @InjectMocks
    private MascotasDAOImpl mascotasDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @BeforeEach
    void init() throws SQLException {
        mascotasDAO.jdbcTemplate = jdbcTemplate;
    }

    @Test
    void insert() {
        Mascotas entity = new Mascotas();
        when(jdbcTemplate.update(any(),any(),any(),any(),any(),any(),any())).thenReturn(0);
        assertNotNull(mascotasDAO.update(entity));
    }

    @Test
    void update() {
        Mascotas entity = new Mascotas();
        when(jdbcTemplate.update(any(),any(),any(),any(),any(),any(),any())).thenReturn(0);
        assertNotNull(mascotasDAO.update(entity));
    }

    @Test
    void getById() {
        Mascotas mascotas = new Mascotas();

        when(jdbcTemplate.queryForObject(anyString(),any(MascotasMapper.class),anyInt())).thenReturn(mascotas);
        var masc = mascotasDAO.getById(1);
        assertNotNull(masc);
    }

    @Test
    void getByIdExcepcion(){
        when(jdbcTemplate.queryForObject(any(),any(MascotasMapper.class),anyInt())).thenThrow(EmptyResultDataAccessException.class);
        assertNull(mascotasDAO.getById(1));
    }

    @Test
    void getAll() {
        List<Mascotas> mascotasList = Arrays.asList(new Mascotas());

        when(jdbcTemplate.query(anyString(),any(MascotasMapper.class))).thenReturn(mascotasList);
        var lista = mascotasDAO.getAll();
        assertEquals(1,lista.size());
    }

    @Test
    void getByIdPropietario() {
        Mascotas mascotas = new Mascotas();

        when(jdbcTemplate.queryForObject(anyString(),any(MascotasMapper.class),anyInt())).thenReturn(mascotas);
        var masc = mascotasDAO.getById(1);
        assertNotNull(masc);
    }
}