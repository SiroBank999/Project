package Model;

public class Order_detail {
	private int id;
	private String id_order;
	private String productname;
	private String size;
	private int quantity;
	
	public Order_detail() {

	}

	public Order_detail(int id, String id_order, String productname, String size, int quantity) {
		this.id = id;
		this.id_order = id_order;
		this.productname = productname;
		this.size = size;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_order() {
		return id_order;
	}

	public void setId_order(String id_order) {
		this.id_order = id_order;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order_detail [id=" + id + ", id_order=" + id_order + ", productname=" + productname + ", size=" + size
				+ ", quantity=" + quantity + "]";
	}
	
	

}
