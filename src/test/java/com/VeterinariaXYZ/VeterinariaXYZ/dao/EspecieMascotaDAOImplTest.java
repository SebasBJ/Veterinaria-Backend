package com.VeterinariaXYZ.VeterinariaXYZ.dao;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.EspecieMascota;
import com.VeterinariaXYZ.VeterinariaXYZ.mapper.EspecieMascotaMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class EspecieMascotaDAOImplTest {
    @InjectMocks
    private EspecieMascotaDAOImpl especieMascotaDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @BeforeEach
    void init() throws SQLException {
        especieMascotaDAO.jdbcTemplate = jdbcTemplate;
    }

    @Test
    void getAll() {
        List<EspecieMascota> especieMascotaList = Arrays.asList(new EspecieMascota());

        when(jdbcTemplate.query(anyString(),any(EspecieMascotaMapper.class))).thenReturn(especieMascotaList);
        var lista = especieMascotaDAO.getAll();
        assertEquals(1,lista.size());
    }
}