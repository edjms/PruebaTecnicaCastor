package com.castor.gestion_empleado_backend.service.impl;

import com.castor.gestion_empleado_backend.exception.NotFoundException;
import com.castor.gestion_empleado_backend.model.Cargo;
import com.castor.gestion_empleado_backend.model.Empleado;
import com.castor.gestion_empleado_backend.repository.CargoRepository;
import com.castor.gestion_empleado_backend.repository.EmpleadoRepository;
import com.castor.gestion_empleado_backend.service.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        Optional<Empleado> consultarEmpleado = empleadoRepository.findByCedula(empleado.getCedula());
        if (consultarEmpleado.isPresent()) {
            throw new NotFoundException("Ya existe un empleado con cedula: " + empleado.getCedula());
        }
        Cargo consultarCargo = cargoRepository.findByNombreCargo(empleado.getCargo().getNombreCargo())
                .orElseThrow(() -> new RuntimeException("Cargo con nombre " + empleado.getCargo().getNombreCargo() + " no encontrado"));
        empleado.setCargo(consultarCargo);
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> findAllEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> findByCedula(Long cedula) {
        return empleadoRepository.findByCedula(cedula);
    }

    @Override
    public Optional<Empleado> findByIdEmpleado(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado) {
        Optional<Empleado> ActualizarEmpleado= empleadoRepository.findById(empleado.getId());
        if (!ActualizarEmpleado.isPresent()){
            throw new NotFoundException("no existe un empleado con id: " + empleado.getId());
        }
        return empleadoRepository.save(empleado);
    }


    @Override
    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

}


