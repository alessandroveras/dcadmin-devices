package br.edu.infnet.dcadmin.devices.model.domain;

public class Compute extends Device {

	private String cpu;
	private String memory;

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

}
