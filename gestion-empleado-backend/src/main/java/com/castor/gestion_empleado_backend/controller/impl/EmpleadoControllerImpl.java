package com.castor.gestion_empleado_backend.controller.impl;

import com.castor.gestion_empleado_backend.controller.EmpleadoController;
import com.castor.gestion_empleado_backend.model.Empleado;
import com.castor.gestion_empleado_backend.service.EmpleadoService;
import com.castor.gestion_empleado_backend.service.impl.EmpleadoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class EmpleadoControllerImpl implements EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoService.findAllEmpleado();
    }

    @Override
    public ResponseEntity<Empleado> obtenerEmpleadoPorCedula(Long cedula) {
        return empleadoService.findByCedula(cedula)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Override
    public ResponseEntity<Empleado> actualizarEmpleado(Long id, Empleado empleado) {
        return empleadoService.findByIdEmpleado(id)
                .map(empleadoEncontrado -> {
                    empleadoEncontrado.setCedula(empleado.getCedula());
                    empleadoEncontrado.setNombre(empleado.getNombre());
                    empleadoEncontrado.setRutaFoto(empleado.getRutaFoto());
                    empleadoEncontrado.setFechaIngreso(empleado.getFechaIngreso());
                    empleadoEncontrado.setCargo(empleado.getCargo());


                    Empleado empleadoActualizado = empleadoService.updateEmpleado(empleadoEncontrado);
                    return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<String> eliminarEmpleado(Long id) {
        empleadoService.deleteEmpleado(id);
        return new ResponseEntity<>("200 ok",HttpStatus.OK);
    }
}
