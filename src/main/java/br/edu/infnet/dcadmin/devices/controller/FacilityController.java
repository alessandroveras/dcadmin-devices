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

import br.edu.infnet.dcadmin.devices.model.domain.Facility;
import br.edu.infnet.dcadmin.devices.model.service.FacilityService;

@RestController
@RequestMapping(value = "/facilities")
public class FacilityController {

	@Autowired
	private FacilityService facilityService;

	@PostMapping
	public ResponseEntity<Facility> create(@RequestBody Facility facility) {
		Facility createdFacility = facilityService.create(facility);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdFacility.getId())
				.toUri();
		return ResponseEntity.created(uri).body(createdFacility);
	}

	@GetMapping
	public ResponseEntity<List<Facility>> retrieve() {
		List<Facility> facilities = facilityService.retrieve();
		return ResponseEntity.ok().body(facilities);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Facility> update(@PathVariable Long id, @RequestBody Facility facility) {
		Facility updatedFacility = facilityService.update(id, facility);
		return ResponseEntity.ok().body(updatedFacility);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		facilityService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Facility> findById(@PathVariable Long id) {
		Facility facility = facilityService.findById(id);
		return ResponseEntity.ok().body(facility);
	}

}
