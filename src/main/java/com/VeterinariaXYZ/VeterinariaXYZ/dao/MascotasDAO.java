package com.VeterinariaXYZ.VeterinariaXYZ.dao;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Mascotas;
import java.util.List;

public interface MascotasDAO {
    Mascotas insert(Mascotas mascotas);
    Mascotas update(Mascotas mascotas);
    Mascotas getById(int nmid);
    List<Mascotas> getAll();
    List<Mascotas> getByIdPropietario(int nmid_propietarios);
}
