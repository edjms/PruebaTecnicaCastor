package com.castor.gestion_empleado_backend.controller;

import com.castor.gestion_empleado_backend.model.Empleado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/empleado")
@CrossOrigin(origins = "http://localhost:4200")
public interface EmpleadoController {

    @PostMapping("/guardar/")
    Empleado guardarEmpleado(@RequestBody Empleado empleado);

    @GetMapping("/listar/")
    List<Empleado> obtenerTodosLosEmpleados();

    @GetMapping("/listar/{cedula}")
    ResponseEntity<Empleado> obtenerEmpleadoPorCedula (@PathVariable("cedula")Long cedula);

    @PutMapping("/actualizar/{id}")
    ResponseEntity<Empleado> actualizarEmpleado (@PathVariable("id") Long id, @RequestBody Empleado empleado);

    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<String> eliminarEmpleado (@PathVariable("id") Long id);
}
