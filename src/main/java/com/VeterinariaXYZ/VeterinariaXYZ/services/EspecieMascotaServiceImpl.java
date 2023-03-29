package com.VeterinariaXYZ.VeterinariaXYZ.services;

import com.VeterinariaXYZ.VeterinariaXYZ.dao.EspecieMascotaDAO;
import com.VeterinariaXYZ.VeterinariaXYZ.dto.EspecieMascota;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EspecieMascotaServiceImpl implements EspecieMascotaService{

    private Logger log = LoggerFactory.getLogger(EspecieMascotaServiceImpl.class);

    private final EspecieMascotaDAO especieMascotaDAO;

    public EspecieMascotaServiceImpl(EspecieMascotaDAO especieMascotaDAO){
        this.especieMascotaDAO = especieMascotaDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EspecieMascota> finAll() {
        log.debug("Request to get all especie_mascotas");
        return especieMascotaDAO.getAll();
    }
}
