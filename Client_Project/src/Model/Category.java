package Model;

public class Category {
	private int id ;
	private String categoryname;
	private String img ;
	public Category(int id, String categoryname, String img) {
		
		this.id = id;
		this.categoryname = categoryname;
		this.img = img;
	}
	public Category() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
		
}
