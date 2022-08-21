package br.edu.infnet.dcadmin.devices.model.domain;

public class Network extends Device {

	private String type;
	private String role;

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

}
