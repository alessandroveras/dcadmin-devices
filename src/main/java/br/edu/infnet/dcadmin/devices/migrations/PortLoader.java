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
		Port port = null;
		Device device = null;

		try {
			device = new Device();
			device = deviceService.findById(1L);
			
			port = new Port();
			port.setAlias("TenGigabitEthernet0/0/0/0");
			port.setMediaType("10GBASE-SR");
			port.setSpeed(10000);
			port.setDevice(device);

			portService.create(port);

			System.out.println("Inclusao de port realizada com sucesso");

		} catch (Exception e) {
			System.out.println("[ERROR] Inpossivel realziar a inclusão do port");
			System.out.println("");
		}

	}

}
