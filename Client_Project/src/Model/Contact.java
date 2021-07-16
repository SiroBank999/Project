package Model;

public class Contact {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String content;
	private String status;

	public Contact() {
	}

	public Contact(int id, String name, String phone, String email, String content, String status) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.content = content;
		this.status = status;
	}

	public Contact(String name, String phone, String email, String content, String status) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.content = content;
		this.status = status;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
