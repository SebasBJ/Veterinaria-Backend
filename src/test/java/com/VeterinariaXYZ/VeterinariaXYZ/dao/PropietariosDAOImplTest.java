package com.VeterinariaXYZ.VeterinariaXYZ.dao;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;
import com.VeterinariaXYZ.VeterinariaXYZ.mapper.PropietariosMapper;
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
class PropietariosDAOImplTest {

    @InjectMocks
    private PropietariosDAOImpl propietariosDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @BeforeEach
    void init() throws SQLException {
        propietariosDAO.jdbcTemplate = jdbcTemplate;
    }

    @Test
    void insert() {
        Propietarios entity = new Propietarios();
        when(jdbcTemplate.update(any(),any(),any(),any(),any(),any(),any(),any())).thenReturn(0);
        assertNotNull(propietariosDAO.update(entity));
    }

    @Test
    void update() {
        Propietarios entity = new Propietarios();
        when(jdbcTemplate.update(any(),any(),any(),any(),any(),any(),any(),any())).thenReturn(0);
        assertNotNull(propietariosDAO.update(entity));
    }

    @Test
    void getById() {
        Propietarios propietarios = new Propietarios();

        when(jdbcTemplate.queryForObject(anyString(),any(PropietariosMapper.class),anyInt())).thenReturn(propietarios);
        var pro = propietariosDAO.getById(1);
        assertNotNull(pro);
    }

    @Test
    void getByIdExcepcion(){
        when(jdbcTemplate.queryForObject(any(),any(PropietariosMapper.class),anyInt())).thenThrow(EmptyResultDataAccessException.class);
        assertNull(propietariosDAO.getById(1));
    }
    @Test
    void getAll() {
        List<Propietarios> propietariosList = Arrays.asList(new Propietarios());

        when(jdbcTemplate.query(anyString(),any(PropietariosMapper.class))).thenReturn(propietariosList);
        var lista = propietariosDAO.getAll();
        assertEquals(1,lista.size());
    }
}