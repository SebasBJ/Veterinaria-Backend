package com.VeterinariaXYZ.VeterinariaXYZ.dto;

import com.VeterinariaXYZ.VeterinariaXYZ.util.UtilDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Data
public class Propietarios implements Serializable {

    private static final long serialVersionUID = 1L;
    private int nmid;
    private String dsnombre_completo;
    private String dstipo_documento;
    private int nmidentificacion;
    private String dsciudad;
    private String dsdireccion;
    private int nmtelefono;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtfecha_registro;

    @JsonIgnore
    public void setPropietariosFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        dsnombre_completo = rs.getString("dsnombre_completo");
        dstipo_documento = rs.getString("dstipo_documento");
        nmidentificacion = rs.getInt("nmidentificacion");
        dsciudad = rs.getString("dsciudad");
        dsdireccion = rs.getString("dsdireccion");
        nmtelefono = rs.getInt("nmtelefono");
        dtfecha_registro = UtilDate.getLocalDate(rs.getDate("dtfecha_registro"));
    }
}
