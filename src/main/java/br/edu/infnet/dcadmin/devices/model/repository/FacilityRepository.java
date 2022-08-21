package br.edu.infnet.dcadmin.devices.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.dcadmin.devices.model.domain.Facility;

public interface FacilityRepository extends CrudRepository<Facility, Integer> {
	
}
