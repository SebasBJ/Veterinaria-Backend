package com.VeterinariaXYZ.VeterinariaXYZ.services;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MascotasService {
    Mascotas save(Mascotas mascotas);

    Mascotas update(Mascotas mascotas);

    List<Mascotas> finAll();

    Mascotas finOne(int nmid);

    @Transactional(readOnly = true)
    List<Mascotas> finByIdPropietario(int nmid_propietarios);
}
