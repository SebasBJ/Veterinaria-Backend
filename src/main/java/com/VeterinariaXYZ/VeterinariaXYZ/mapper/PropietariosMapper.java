package com.VeterinariaXYZ.VeterinariaXYZ.mapper;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;
import com.VeterinariaXYZ.VeterinariaXYZ.util.UtilDate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PropietariosMapper implements RowMapper<Propietarios> {
    @Override
    public Propietarios mapRow(ResultSet resultSet, int i)throws SQLException {
        Propietarios propietarios = new Propietarios();
        propietarios.setNmid(resultSet.getInt("nmid"));
        propietarios.setDsnombre_completo(resultSet.getString("dsnombre_completo"));
        propietarios.setDstipo_documento(resultSet.getString("dstipo_documento"));
        propietarios.setNmidentificacion(resultSet.getInt("nmidentificacion"));
        propietarios.setDsciudad(resultSet.getString("dsciudad"));
        propietarios.setDsdireccion(resultSet.getString("dsdireccion"));
        propietarios.setNmtelefono(resultSet.getInt("nmtelefono"));
        propietarios.setDtfecha_registro(UtilDate.getLocalDate(resultSet.getDate("dtfecha_registro")));
        propietarios.setPropietariosFromRs(resultSet);
        return propietarios;
    }
}
