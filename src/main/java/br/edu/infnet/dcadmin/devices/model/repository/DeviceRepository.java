package br.edu.infnet.dcadmin.devices.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.dcadmin.devices.model.domain.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

}
