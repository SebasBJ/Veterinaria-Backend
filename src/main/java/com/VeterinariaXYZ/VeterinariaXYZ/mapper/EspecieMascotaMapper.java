package com.VeterinariaXYZ.VeterinariaXYZ.mapper;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.EspecieMascota;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecieMascotaMapper implements RowMapper<EspecieMascota> {
    @Override
    public EspecieMascota mapRow(ResultSet resultSet, int i)throws SQLException {
        EspecieMascota especieMascota = new EspecieMascota();
        especieMascota.setNmid(resultSet.getInt("nmid"));
        especieMascota.setDsespecie(resultSet.getString("dsespecie"));
        especieMascota.setEspecieFromRs(resultSet);
        return especieMascota;
    }
}
