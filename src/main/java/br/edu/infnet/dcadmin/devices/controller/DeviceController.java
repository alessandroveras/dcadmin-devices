package br.edu.infnet.dcadmin.devices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.infnet.dcadmin.devices.model.domain.Device;
import br.edu.infnet.dcadmin.devices.model.service.DeviceService;

@RestController
@RequestMapping(value = "/devices")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@PostMapping
	public ResponseEntity<Device> create(@RequestBody Device device) {
		Device createdDevice = deviceService.create(device);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdDevice.getId())
				.toUri();
		return ResponseEntity.created(uri).body(createdDevice);
	}

	@GetMapping
	public ResponseEntity<List<Device>> retrieve() {
		List<Device> devices = deviceService.retrieve();
		return ResponseEntity.ok().body(devices);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Device> update(@PathVariable Long id, @RequestBody Device device) {
		Device updatedDevice = deviceService.update(id, device);
		return ResponseEntity.ok().body(updatedDevice);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		deviceService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Device> findById(@PathVariable Long id) {
		Device device = deviceService.findById(id);
		return ResponseEntity.ok().body(device);
	}

	@GetMapping(value = "/{id}/bandwith")
	public Integer calculateBandwith(@PathVariable Long id) {
		return 30;
	}

}
