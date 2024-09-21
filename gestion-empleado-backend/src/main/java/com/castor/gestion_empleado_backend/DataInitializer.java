package com.castor.gestion_empleado_backend;

import com.castor.gestion_empleado_backend.model.Cargo;
import com.castor.gestion_empleado_backend.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private CargoRepository cargoRepository;

	@Override
	public void run(String... args) throws Exception {
		// Verificar si ya hay datos
		if (cargoRepository.count() == 0) {
			cargoRepository.save(new Cargo(1L, "Scrum Master"));
			cargoRepository.save(new Cargo(2L, "Desarrollador"));
			cargoRepository.save(new Cargo(3L, "QA"));
			cargoRepository.save(new Cargo(4L, "PO"));
		}
	}
}*/
