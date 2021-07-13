package Model;

import java.sql.Date;

public class Product {
	private int id;
	private String productname;
	private int price;
	private int sale;
	private String image;
	private Date date;
	private String describe;
	private int id_category;
	private String fabric;
	private String status;

	public Product() {

	}
	public Product(int id, String productname, int price, int sale, String image, Date date, String describe,
			int id_category, String fabric, String status) {
		this.id = id;
		this.productname = productname;
		this.price = price;
		this.sale = sale;
		this.image = image;
		this.date = date;
		this.describe = describe;
		this.id_category = id_category;
		this.fabric = fabric;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", price=" + price + ", sale=" + sale + ", image="
				+ image + ", date=" + date + ", describe=" + describe + ", id_category=" + id_category + ", fabric="
				+ fabric + ", status=" + status + "]";
	}
	
	
	
 
	
	
	


}
