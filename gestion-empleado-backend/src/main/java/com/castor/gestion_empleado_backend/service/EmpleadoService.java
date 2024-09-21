package com.castor.gestion_empleado_backend.service;
import com.castor.gestion_empleado_backend.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    Empleado saveEmpleado (Empleado empleado);
    List<Empleado> findAllEmpleado();
    Optional<Empleado> findByCedula(Long cedula);
    Optional<Empleado> findByIdEmpleado (Long id);
    Empleado updateEmpleado (Empleado empleado);
    void deleteEmpleado (Long id);
}


