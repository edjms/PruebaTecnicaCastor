package com.castor.gestion_empleado_backend;

import com.castor.gestion_empleado_backend.model.Cargo;
import com.castor.gestion_empleado_backend.repository.CargoRepository;
import com.castor.gestion_empleado_backend.repository.EmpleadoRepository;
import com.castor.gestion_empleado_backend.service.EmpleadoService;
import com.castor.gestion_empleado_backend.service.impl.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class GestionEmpleadoBackendApplication {

	public CargoRepository cargoRepository;
	public static void main(String[] args) {

		SpringApplication.run(GestionEmpleadoBackendApplication.class, args

		);
		}



	}

