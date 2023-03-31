package com.VeterinariaXYZ.VeterinariaXYZ.dao;

import com.VeterinariaXYZ.VeterinariaXYZ.dto.Propietarios;
import java.util.List;

public interface PropietariosDAO {
    Propietarios insert(Propietarios propietarios);
    Propietarios update(Propietarios propietarios);
    Propietarios getById(int nmid);
    List<Propietarios> getAll();
}
