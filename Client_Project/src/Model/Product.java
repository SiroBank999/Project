package Model;

import java.sql.Date;

public class Product {
	private int idSanpham;
	private String productName;
	private int price;
	private int sale;
	private String img;
	private Date date;
	private String describe;
	private String fabric;
	private int status;
	private int views;
	private int id;

	public Product() {

	}

	public Product(int idSanpham, String productName, int price, int sale, String img, Date date, String describe,
			String fabric, int status, int views, int id) {
		super();
		this.idSanpham = idSanpham;
		this.productName = productName;
		this.price = price;
		this.sale = sale;
		this.img = img;
		this.date = date;
		this.describe = describe;
		this.fabric = fabric;
		this.status = status;
		this.views = views;
		this.id = id;
	}

	public int getIdSanpham() {
		return idSanpham;
	}

	public void setIdSanpham(int idSanpham) {
		this.idSanpham = idSanpham;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
