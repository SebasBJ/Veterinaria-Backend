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
public class Mascotas implements Serializable {
    private static final long serialVersionUID = 1L;
    private int nmid;
    private String dsnombre_mascota;
    private String dsraza;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtfecha_nacimiento;
    private int nmid_propietarios;
    private int nmid_especie;
    private String dsnombre_completo;
    private String dsespecie;

    @JsonIgnore
    public void setMascotasFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        dsnombre_mascota = rs.getString("dsnombre_mascota");
        dsraza = rs.getString("dsraza");
        dtfecha_nacimiento = UtilDate.getLocalDate(rs.getDate("dtfecha_nacimiento"));
        nmid_propietarios = rs.getInt("nmid_propietarios");
        nmid_especie = rs.getInt("nmid_especie");
        dsnombre_completo = rs.getString("dsnombre_completo");
        dsespecie = rs.getString("dsespecie");
    }
}
