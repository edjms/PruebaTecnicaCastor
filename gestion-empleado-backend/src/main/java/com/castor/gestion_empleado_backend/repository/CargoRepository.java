package com.castor.gestion_empleado_backend.repository;

import com.castor.gestion_empleado_backend.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    Optional<Cargo> findByNombreCargo(String nombreCargo);

}
