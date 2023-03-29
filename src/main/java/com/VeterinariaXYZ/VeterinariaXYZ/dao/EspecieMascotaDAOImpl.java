package com.VeterinariaXYZ.VeterinariaXYZ.dao;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.EspecieMascota;
import com.VeterinariaXYZ.VeterinariaXYZ.mapper.EspecieMascotaMapper;
import org.springframework.cache.CacheManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class EspecieMascotaDAOImpl implements EspecieMascotaDAO{
    private static final String SELECT = "SELECT * FROM `especie_mascotas`";
    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;
    public EspecieMascotaDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<EspecieMascota> getAll() {
        return jdbcTemplate.query(SELECT, new EspecieMascotaMapper());
    }
}
