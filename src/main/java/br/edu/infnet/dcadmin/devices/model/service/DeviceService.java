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
import br.edu.infnet.dcadmin.devices.model.domain.Device;
import br.edu.infnet.dcadmin.devices.model.repository.DeviceRepository;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;

	public Device create(Device device) {
		return deviceRepository.save(device);
	}

	public List<Device> retrieve() {
		return (List<Device>) deviceRepository.findAll();
	}

	public Device update(Long id, Device device) {
		try {
			@SuppressWarnings("deprecation")
			Device editedDevice = deviceRepository.getOne(id);
			editedDevice.setHostname(device.getHostname());
			editedDevice.setRole(device.getRole());
			return deviceRepository.save(editedDevice);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void delete(Long id) {
		try {
			deviceRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Device findById(Long id) {
		Optional<Device> device = deviceRepository.findById(id);
		return device.orElseThrow(() -> new ResourceNotFoundException(id));
	}

}
