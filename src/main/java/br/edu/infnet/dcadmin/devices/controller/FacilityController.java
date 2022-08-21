package br.edu.infnet.dcadmin.devices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.dcadmin.devices.model.domain.Facility;
import br.edu.infnet.dcadmin.devices.model.service.FacilityService;

@RestController
@RequestMapping(value = "/api/facility")
public class FacilityController {

	@Autowired
	private FacilityService facilityService;

	@GetMapping(value = "/{id}/listar")
	public Facility obterPorId(@PathVariable Integer id) {

		return facilityService.obterPorId(id);
	}

	@GetMapping(value = "/listar")
	public List<Facility> obterLista() {

		return facilityService.obterLista();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Facility facility) {

		facilityService.incluir(facility);

	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {

		facilityService.excluir(id);

	}

}
