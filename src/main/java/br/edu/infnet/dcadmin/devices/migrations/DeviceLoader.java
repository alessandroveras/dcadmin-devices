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
		Device device = null;

		try {
			device = new Device();
			device.setSerialNumber("FCA111111");
			device.setHostname("DEMO-DEVICE-1");
			device.setType("ROUTER");
			device.setRole("EDGE");
			device.setFabricCapacity(320000);

			deviceService.create(device);

			System.out.println("Inclusao de device realizada com sucesso");

		} catch (Exception e) {
			System.out.println("[ERROR] Impossivel realziar a inclusão do device");
			System.out.println("");
		}

	}

}
