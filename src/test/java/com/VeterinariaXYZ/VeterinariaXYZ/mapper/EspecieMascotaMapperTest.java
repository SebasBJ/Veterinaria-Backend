package com.VeterinariaXYZ.VeterinariaXYZ.mapper;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.EspecieMascota;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class EspecieMascotaMapperTest {
    @Test
    public void mapRow() throws SQLException {
        EspecieMascotaMapper mapper = new EspecieMascotaMapper();
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getInt("nmid")).thenReturn(1);
        when(resultSet.getString("dsespecie")).thenReturn("Loro");
        EspecieMascota expectEspecie = mapper.mapRow(resultSet,0);
        assertEquals(1, expectEspecie.getNmid());
        assertEquals("Loro", expectEspecie.getDsespecie());
    }
}