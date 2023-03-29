package com.VeterinariaXYZ.VeterinariaXYZ.dao;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import com.VeterinariaXYZ.VeterinariaXYZ.mapper.MascotasMapper;
import com.VeterinariaXYZ.VeterinariaXYZ.util.DaoUtil;
import org.springframework.cache.CacheManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class MascotasDAOImpl implements MascotasDAO{
    private static final String INSERT = "INSERT INTO `mascotas`(`nmid`, `dsnombre_mascota`, `dsraza`, `dtfecha_nacimiento`, `nmid_propietarios`, `nmid_especie`) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE `mascotas` SET `dsnombre_mascota`= ?,`dsraza`= ?,`dtfecha_nacimiento`= ?,`nmid_propietarios`= ?,`nmid_especie`= ? WHERE nmid = ?";
    private static final String SELECT = "SELECT * FROM `especie_mascotas`";
    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";
    private static final String SELECTESPECIE = "SELECT mas.nmid, mas.dsnombre_mascota, mas.dsraza, mas.dtfecha_nacimiento, mas.nmid_propietarios, mas.nmid_especie, pro.dsnombre_completo, esp.dsespecie\n" +
            "FROM mascotas mas\n" +
            "INNER JOIN propietarios_mascotas pro ON mas.nmid_propietarios = pro.nmid\n" +
            "INNER JOIN especie_mascotas esp ON mas.nmid_especie = esp.nmid";
    private static final String WHERE = SELECTESPECIE + " WHERE mas.nmid_propietarios = ?";
    private static final String ORDERBY = " ORDER BY mas.dsnombre_mascota;";
    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public MascotasDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Mascotas insert(Mascotas mascotas) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{"nmid"});
            DaoUtil.setPrepareStatement(ps, new Object[]{
                    mascotas.getNmid(),
                    mascotas.getDsnombre_mascota(),
                    mascotas.getDsraza(),
                    mascotas.getDtfecha_nacimiento(),
                    mascotas.getNmid_propietarios(),
                    mascotas.getNmid_especie()
            });
            return ps;
        }, keyHolder);
        mascotas.setNmid(keyHolder.getKey().intValue());
        return mascotas;
    }

    @Override
    public Mascotas update(Mascotas mascotas) {
        jdbcTemplate.update(UPDATE,
                mascotas.getDsnombre_mascota(),
                mascotas.getDsraza(),
                mascotas.getDtfecha_nacimiento(),
                mascotas.getNmid_propietarios(),
                mascotas.getNmid_especie(),
                mascotas.getNmid());
        return mascotas;
    }

    @Override
    public Mascotas getById(int nmid) {
        try {
            return jdbcTemplate.queryForObject(SELECTBYID, new MascotasMapper(), nmid);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Mascotas> getAll() {
        return jdbcTemplate.query(SELECTESPECIE, new MascotasMapper());
    }

    @Override
    public List<Mascotas> getByIdPropietario(int nmid_propietarios) {
        try {
            return jdbcTemplate.query(WHERE, new MascotasMapper(), nmid_propietarios);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }
}
