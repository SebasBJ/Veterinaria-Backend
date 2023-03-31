package com.VeterinariaXYZ.VeterinariaXYZ.services;

import com.VeterinariaXYZ.VeterinariaXYZ.dao.PropietariosDAO;
import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PropietariosServiceImpl implements PropietariosService {

    private Logger log = LoggerFactory.getLogger(PropietariosServiceImpl.class);

    private final PropietariosDAO propietariosDAO;

    public PropietariosServiceImpl(PropietariosDAO propietariosDAO){
        this.propietariosDAO = propietariosDAO;
    }

    @Override
    public Propietarios save(Propietarios propietarios) {
        log.debug("Request to insert propietarios_mascotas: {}", propietarios);
        return propietariosDAO.insert(propietarios);
    }

    @Override
    public Propietarios update(Propietarios propietarios) {
        log.debug("Request to get all propietarios_mascotas: {}", propietarios);
        return propietariosDAO.update(propietarios);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Propietarios> finAll() {
        log.debug("Request to get all propietarios_mascotas: {}");
        return propietariosDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Propietarios finOne(int nmid) {
        log.debug("Request to get propietarios_mascotas: {}", nmid);
        return propietariosDAO.getById(nmid);
    }
}
