package Model;

public class Admin {
	private int id;
	private String displayname;
	private String username;
	private String password;
	private int level;
	public Admin() {
	}
	public Admin(int id, String displayname, String username, String password, int level) {
		this.id = id;
		this.displayname = displayname;
		this.username = username;
		this.password = password;
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", displayname=" + displayname + ", username=" + username + ", password=" + password
				+ ", level=" + level + "]";
	}
	
	
}
