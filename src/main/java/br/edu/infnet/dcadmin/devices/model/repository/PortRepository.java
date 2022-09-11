package br.edu.infnet.dcadmin.devices.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.dcadmin.devices.model.domain.Port;

@Repository
public interface PortRepository extends JpaRepository<Port, Long> {

}
