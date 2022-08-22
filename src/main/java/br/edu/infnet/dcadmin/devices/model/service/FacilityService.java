package br.edu.infnet.dcadmin.devices.model.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.infnet.dcadmin.devices.exceptions.DatabaseException;
import br.edu.infnet.dcadmin.devices.exceptions.ResourceNotFoundException;
import br.edu.infnet.dcadmin.devices.model.domain.Facility;
import br.edu.infnet.dcadmin.devices.model.repository.FacilityRepository;

@Service
public class FacilityService {

	@Autowired
	private FacilityRepository facilityRepository;

	public Facility create(Facility facility) {
		return facilityRepository.save(facility);
	}

	public List<Facility> retrieve() {
		return (List<Facility>) facilityRepository.findAll();
	}

	public Facility update(Long id, Facility facility) {
		try {
			@SuppressWarnings("deprecation")
			Facility editedFacility = facilityRepository.getOne(id);
			editedFacility.setName(facility.getName());
			editedFacility.setType(facility.getType());
			editedFacility.setAddress(facility.getAddress());
			return facilityRepository.save(editedFacility);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void delete(Long id) {
		try {
			facilityRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Facility findById(Long id) {
		Optional<Facility> facility = facilityRepository.findById(id);
		return facility.orElseThrow(() -> new ResourceNotFoundException(id));
	}

}
