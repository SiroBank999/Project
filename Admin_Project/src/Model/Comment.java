package Model;

import java.sql.Date;

public class Comment {
	public int id;
	public String content;
	public Date datesub;
	public int id_user;
	public int status;
	public Comment() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDatesub() {
		return datesub;
	}
	public void setDatesub(Date datesub) {
		this.datesub = datesub;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
