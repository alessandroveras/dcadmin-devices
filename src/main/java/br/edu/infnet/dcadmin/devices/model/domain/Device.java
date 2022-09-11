package br.edu.infnet.dcadmin.devices.model.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TDEVICE")
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String serialNumber;
	private String hostname;
	private String type;
	private String role;
	private Integer fabricCapacity;

	@OneToMany()
	private Set<Port> ports = new HashSet<>();

	public Device() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getFabricCapacity() {
		return fabricCapacity;
	}

	public void setFabricCapacity(Integer fabricCapacity) {
		this.fabricCapacity = fabricCapacity;
	}

	public Set<Port> getPorts() {
		return ports;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", serialNumber=" + serialNumber + ", hostname=" + hostname + ", type=" + type
				+ ", role=" + role + ", fabricCapacity=" + fabricCapacity + ", ports=" + ports + "]";
	}

	

}
