package br.edu.infnet.dcadmin.devices.migrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.dcadmin.devices.model.domain.Device;
import br.edu.infnet.dcadmin.devices.model.service.DeviceService;

@Order(1)
@Component
public class DeviceLoader implements ApplicationRunner {

	@Autowired
	private DeviceService deviceService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("[INFO]:::::::::::::::::::::::::::::: Execucao do loader do device");
		
		Device deviceA = null;
		Device deviceB = null;

		try {
			deviceA = new Device();
			deviceA.setSerialNumber("FCA111111");
			deviceA.setHostname("DEMO-DEVICE-1");
			deviceA.setType("ROUTER");
			deviceA.setRole("EDGE");
			deviceA.setFabricCapacity(320000);
			
			deviceService.create(deviceA);
			
			deviceB = new Device();
			deviceB.setSerialNumber("FCA222222");
			deviceB.setHostname("DEMO-DEVICE-2");
			deviceB.setType("ROUTER");
			deviceB.setRole("EDGE");
			deviceB.setFabricCapacity(320000);
			
			deviceService.create(deviceB);

			System.out.println("Inclusao de device realizada com sucesso");

		} catch (Exception e) {
			System.out.println("[ERROR] Impossivel realziar a inclusão do device");
			System.out.println("");
		}

	}

}
