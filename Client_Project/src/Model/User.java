
package Model;


public class User {
	private int id;
	private String fullname;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String status ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User() {
		super();
	}
	public User(int id, String fullname, String username, String password, String phone, String email,
			String status) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.status = status;
	}
	
	public User(String fullname, String username, String password, String phone, String email, String status) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", username=" + username + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", status=" + status + "]";
	}
	
	
}
