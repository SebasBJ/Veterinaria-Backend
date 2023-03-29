package com.VeterinariaXYZ.VeterinariaXYZ.mapper;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MascotasMapperTest {

    @Test
    public void mapRow() throws SQLException {
        MascotasMapper mapper = new MascotasMapper();
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getInt("nmid")).thenReturn(1);
        when(resultSet.getString("dsnombre_mascota")).thenReturn("Lupita");
        when(resultSet.getString("dsraza")).thenReturn("Labrador");
        when(resultSet.getDate("dtfecha_nacimiento")).thenReturn(any());
        when(resultSet.getInt("nmid_propietarios")).thenReturn(1);
        when(resultSet.getInt("nmid_especie")).thenReturn(1);
        Mascotas expectMascotas = mapper.mapRow(resultSet, 0);
        assertEquals(1,expectMascotas.getNmid());
        assertEquals("Lupita",expectMascotas.getDsnombre_mascota());
        assertEquals("Labrador",expectMascotas.getDsraza());
        assertEquals(1,expectMascotas.getNmid_propietarios());
        assertEquals(1,expectMascotas.getNmid_especie());
    }
}