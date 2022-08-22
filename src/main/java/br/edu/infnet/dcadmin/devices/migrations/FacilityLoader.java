package br.edu.infnet.dcadmin.devices.migrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.dcadmin.devices.model.domain.Facility;
import br.edu.infnet.dcadmin.devices.model.service.FacilityService;

@Component
public class FacilityLoader implements ApplicationRunner {

	@Autowired
	private FacilityService facilityService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("[INFO]:::::::::::::::::::::::::::::: Execucao do loader do facility");
		Facility facility = null;

		try {
			facility = new Facility();
			facility.setName("CH1");
			facility.setType("Core");
			facility.setAddress("350 E Cermak Rd, 5th Floor, IL, US, 60616");

			facilityService.create(facility);

			System.out.println("Inclusao de facility realizada com sucesso");

		} catch (Exception e) {
			System.out.println("[ERROR] Inpossivel realziar a inclusão do facility");
			System.out.println("");
		}

	}

}
