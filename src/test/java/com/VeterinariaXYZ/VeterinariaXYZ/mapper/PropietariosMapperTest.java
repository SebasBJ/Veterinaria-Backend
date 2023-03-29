package com.VeterinariaXYZ.VeterinariaXYZ.mapper;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PropietariosMapperTest {

    @Test
    public void mapRow() throws SQLException {
        PropietariosMapper mapper = new PropietariosMapper();
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getInt("nmid")).thenReturn(1);
        when(resultSet.getString("dsnombre_completo")).thenReturn("Sebastian");
        when(resultSet.getString("dstipo_documento")).thenReturn("C.C");
        when(resultSet.getInt("nmidentificacion")).thenReturn(1234567891);
        when(resultSet.getString("dsciudad")).thenReturn("Medellin");
        when(resultSet.getString("dsdireccion")).thenReturn("Calle 97B");
        when(resultSet.getInt("nmtelefono")).thenReturn(1234567897);
        when(resultSet.getDate("dtfecha_registro")).thenReturn(Date.valueOf("2023-05-06"));
        Propietarios expectPropietarios = mapper.mapRow(resultSet,0);
        assertEquals(1, expectPropietarios.getNmid());
        assertEquals("Sebastian", expectPropietarios.getDsnombre_completo());
        assertEquals("C.C", expectPropietarios.getDstipo_documento());
        assertEquals(1234567891, expectPropietarios.getNmidentificacion());
        assertEquals("Medellin", expectPropietarios.getDsciudad());
        assertEquals("Calle 97B", expectPropietarios.getDsdireccion());
        assertEquals(1234567897, expectPropietarios.getNmtelefono());
    }
}