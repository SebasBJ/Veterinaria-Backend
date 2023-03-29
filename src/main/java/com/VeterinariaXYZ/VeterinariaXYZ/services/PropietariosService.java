package com.VeterinariaXYZ.VeterinariaXYZ.services;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;

import java.util.List;

public interface PropietariosService {
    Propietarios save(Propietarios propietarios);

    Propietarios update(Propietarios propietarios);

    List<Propietarios> finAll();

    Propietarios finOne(int nmid);
}
