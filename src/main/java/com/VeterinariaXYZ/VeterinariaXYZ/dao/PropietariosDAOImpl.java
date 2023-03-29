package com.VeterinariaXYZ.VeterinariaXYZ.dao;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;
import com.VeterinariaXYZ.VeterinariaXYZ.mapper.PropietariosMapper;
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
public class PropietariosDAOImpl implements PropietariosDAO {

    private static final String INSERT = "INSERT INTO `propietarios_mascotas`(`nmid`, `dsnombre_completo`, `dstipo_documento`, `nmidentificacion`, `dsciudad`, `dsdireccion`, `nmtelefono`, `dtfecha_registro`) VALUES (?,?,?,?,?,?,?,now())";
    private static final String UPDATE = "UPDATE `propietarios_mascotas` SET `dsnombre_completo`= ?,`dstipo_documento`= ?,`nmidentificacion`= ?,`dsciudad`= ?,`dsdireccion`= ?,`nmtelefono`= ? WHERE nmid = ?";
    private static final String SELECT = "SELECT * FROM `propietarios_mascotas`";
    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";
    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public PropietariosDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Propietarios insert(Propietarios propietarios) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{"nmid"});
            DaoUtil.setPrepareStatement(ps, new Object[]{
                    propietarios.getNmid(),
                    propietarios.getDsnombre_completo(),
                    propietarios.getDstipo_documento(),
                    propietarios.getNmidentificacion(),
                    propietarios.getDsciudad(),
                    propietarios.getDsdireccion(),
                    propietarios.getNmtelefono()
            });
            return ps;
        }, keyHolder);
        propietarios.setNmid(keyHolder.getKey().intValue());
        return propietarios;
    }

    @Override
    public Propietarios update(Propietarios propietarios) {
        jdbcTemplate.update(UPDATE,
                propietarios.getDsnombre_completo(),
                propietarios.getDstipo_documento(),
                propietarios.getNmidentificacion(),
                propietarios.getDsciudad(),
                propietarios.getDsdireccion(),
                propietarios.getNmtelefono(),
                propietarios.getNmid());
        return propietarios;
    }

    @Override
    public Propietarios getById(int nmid) {
        try {
            return jdbcTemplate.queryForObject(SELECTBYID, new PropietariosMapper(), nmid);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Propietarios> getAll() {
        return jdbcTemplate.query(SELECT, new PropietariosMapper());
    }
}
