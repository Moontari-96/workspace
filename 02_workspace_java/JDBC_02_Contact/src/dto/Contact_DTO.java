package dto;

public class Contact_DTO {
	private int id;
	private String name;
	private String phone;
//	private String date;
	public Contact_DTO() {
		super();
	}
	public Contact_DTO(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	public Contact_DTO(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
