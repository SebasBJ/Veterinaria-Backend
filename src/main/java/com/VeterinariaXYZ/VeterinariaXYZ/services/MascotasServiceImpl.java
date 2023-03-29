package com.VeterinariaXYZ.VeterinariaXYZ.services;

import com.VeterinariaXYZ.VeterinariaXYZ.dao.MascotasDAO;
import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MascotasServiceImpl implements MascotasService {

    private Logger log = LoggerFactory.getLogger(MascotasServiceImpl.class);

    private final MascotasDAO mascotasDAO;

    public MascotasServiceImpl(MascotasDAO mascotasDAO){
        this.mascotasDAO = mascotasDAO;
    }

    @Override
    public Mascotas save(Mascotas mascotas) {
        log.debug("Request to insert mascotas: {}", mascotas);
        return mascotasDAO.insert(mascotas);
    }

    @Override
    public Mascotas update(Mascotas mascotas) {
        log.debug("Request to get all mascotas: {}", mascotas);
        return mascotasDAO.update(mascotas);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mascotas> finAll() {
        log.debug("Request to get all mascotas");
        return mascotasDAO.getAll();
    }

    @Override
    public Mascotas finOne(int nmid) {
        log.debug("Request to get mascotas: {}", nmid);
        return mascotasDAO.getById(nmid);
    }

    @Override
    public List<Mascotas> finByIdPropietario(int nmid_propietarios) {
        log.debug("Request to get all mascotas");
        return mascotasDAO.getByIdPropietario(nmid_propietarios);
    }
}
