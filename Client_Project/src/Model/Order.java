package Model;

import java.util.List;

public class Order {
	private int id;
	private String fullname;
	private String phone;
	private String email;
	private String address;
	private User user;
	private List<Item> items;
	private String status;
	private double into;

	public Order() {
	}

	public Order(int id, User user, List<Item> items, String status) {
		this.id = id;
		this.user = user;
		this.items = items;
		this.status = status;

	}

	public Order(int id, String fullname, String phone, String email, String address, String status, double into) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.status = status;
		this.into = into;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getInto() {
		return into;
	}

	public void setInto(double into) {
		this.into = into;
	}

	public double getTotal() {
		double total = 0;
		for (Item item : items) {
			total += item.getPrice() * item.getQuantity();
		}

		return total;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", items=" + items + ", status=" + status + "]";
	}

}