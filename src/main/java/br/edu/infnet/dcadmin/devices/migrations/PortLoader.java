package br.edu.infnet.dcadmin.devices.migrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.dcadmin.devices.model.domain.Device;
import br.edu.infnet.dcadmin.devices.model.domain.Port;
import br.edu.infnet.dcadmin.devices.model.service.DeviceService;
import br.edu.infnet.dcadmin.devices.model.service.PortService;

@Order(2)
@Component
public class PortLoader implements ApplicationRunner {

	@Autowired
	private PortService portService;

	@Autowired
	private DeviceService deviceService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("[INFO]:::::::::::::::::::::::::::::: Execucao do loader de port");
		Device deviceA = null;
		Device deviceB = null;
		Port portA = null;
		Port portB = null;

		try {
			deviceA = new Device();
			deviceA = deviceService.findById(1L);

			deviceB = new Device();
			deviceB = deviceService.findById(2L);

			portA = new Port();
			portA.setAlias("TenGigabitEthernet0/0/0/0");
			portA.setMediaType("10GBASE-SR");
			portA.setSpeed(10000);
			portA.setDevice(deviceA);

			portB = new Port();
			portB.setAlias("TenGigabitEthernet0/0/0/0");
			portB.setMediaType("10GBASE-SR");
			portB.setSpeed(10000);
			portB.setDevice(deviceB);

			portService.create(portA);
			portService.create(portB);

			System.out.println("Inclusao de port realizada com sucesso");

		} catch (Exception e) {
			System.out.println("[ERROR] Inpossivel realziar a inclusão do port");
			System.out.println("");
		}

	}

}
