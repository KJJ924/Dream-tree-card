package prj.dto;

public class DreamTreeInfo {
	private String name;
	private String region;
	private String address;
	private String phone;
	private String theme;
	private String data;
	
	public DreamTreeInfo() {}

	public DreamTreeInfo(String name, String region, String address, String phone, String theme, String data) {
	
		this.name = name;
		this.region = region;
		this.address = address;
		this.phone = phone;
		this.theme = theme;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
}
