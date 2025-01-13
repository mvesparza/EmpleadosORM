package com.espe.empleado.services;

import com.espe.empleado.models.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> findAll();
    Optional<Empleado> findById(Long id);
    Empleado save(Empleado empleado);
    void deleteById(Long id);
}
