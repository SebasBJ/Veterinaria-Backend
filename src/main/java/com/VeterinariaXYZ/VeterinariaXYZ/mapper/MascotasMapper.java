package com.VeterinariaXYZ.VeterinariaXYZ.mapper;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import com.VeterinariaXYZ.VeterinariaXYZ.util.UtilDate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MascotasMapper implements RowMapper<Mascotas> {
    @Override
    public Mascotas mapRow(ResultSet resultSet, int i)throws SQLException {
        Mascotas mascotas = new Mascotas();
        mascotas.setNmid(resultSet.getInt("nmid"));
        mascotas.setDsnombre_mascota(resultSet.getString("dsnombre_mascota"));
        mascotas.setDsraza(resultSet.getString("dsraza"));
        mascotas.setDtfecha_nacimiento(UtilDate.getLocalDate(resultSet.getDate("dtfecha_nacimiento")));
        mascotas.setNmid_propietarios(resultSet.getInt("nmid_propietarios"));
        mascotas.setNmid_especie(resultSet.getInt("nmid_especie"));
        mascotas.setDsnombre_completo(resultSet.getString("dsnombre_completo"));
        mascotas.setDsespecie(resultSet.getString("dsespecie"));
        mascotas.setMascotasFromRs(resultSet);
        return mascotas;
    }
}
