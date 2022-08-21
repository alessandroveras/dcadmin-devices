package br.edu.infnet.dcadmin.devices.model.domain;

public class Storage extends Device {

	private Integer disk_size;
	private String disk_type;
	private Integer numberOfDisks;

	public Integer getDisk_size() {
		return disk_size;
	}

	public void setDisk_size(Integer disk_size) {
		this.disk_size = disk_size;
	}

	public String getDisk_type() {
		return disk_type;
	}

	public void setDisk_type(String disk_type) {
		this.disk_type = disk_type;
	}

	public Integer getNumberOfDisks() {
		return numberOfDisks;
	}

	public void setNumberOfDisks(Integer numberOfDisks) {
		this.numberOfDisks = numberOfDisks;
	}

	public Integer CalculateStorageSize() {

		return disk_size * numberOfDisks;

	}

}
