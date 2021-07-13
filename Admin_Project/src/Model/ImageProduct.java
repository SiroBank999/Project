package Model;

public class ImageProduct {
	private int id;
	private String image;
	private int id_product;
	
	public ImageProduct() {
	}
	public ImageProduct(int id, String image, int id_product) {		super();
		this.id = id;
		this.image = image;
		this.id_product = id_product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	@Override
	public String toString() {
		return "ImageProduct [id=" + id + ", image=" + image + ", id_product=" + id_product + "]";
	}
	
	

}
