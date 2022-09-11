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

import br.edu.infnet.dcadmin.devices.model.domain.Port;
import br.edu.infnet.dcadmin.devices.model.service.PortService;

@RestController
@RequestMapping(value = "/ports")
public class PortController {

	@Autowired
	private PortService portService;

	@PostMapping
	public ResponseEntity<Port> create(@RequestBody Port port) {
		Port createdPort = portService.create(port);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPort.getId())
				.toUri();
		return ResponseEntity.created(uri).body(createdPort);
	}

	@GetMapping
	public ResponseEntity<List<Port>> retrieve() {
		List<Port> facilities = portService.retrieve();
		return ResponseEntity.ok().body(facilities);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Port> update(@PathVariable Long id, @RequestBody Port port) {
		Port updatedPort = portService.update(id, port);
		return ResponseEntity.ok().body(updatedPort);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		portService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Port> findById(@PathVariable Long id) {
		Port port = portService.findById(id);
		return ResponseEntity.ok().body(port);
	}

}
