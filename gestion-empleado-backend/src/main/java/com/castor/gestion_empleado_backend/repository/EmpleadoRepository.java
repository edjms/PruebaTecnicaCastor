package com.castor.gestion_empleado_backend.repository;

import com.castor.gestion_empleado_backend.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByCedula(Long cedula);
}
