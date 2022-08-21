package br.edu.infnet.dcadmin.devices.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dcadmin.devices.model.domain.Facility;
import br.edu.infnet.dcadmin.devices.model.repository.FacilityRepository;

@Service
public class FacilityService {

	@Autowired
	private FacilityRepository facilityRepository;

	public void incluir(Facility facility) {

		facilityRepository.save(facility);
	}

	public void excluir(Integer id) {

		facilityRepository.deleteById(id);
	}

	public List<Facility> obterLista() {

		return (List<Facility>) facilityRepository.findAll();
	}
	
	public Facility obterPorId(Integer id) {
		
		return facilityRepository.findById(id).orElse(null);
	}

}
