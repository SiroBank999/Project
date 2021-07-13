package Model;

public class Color {
	private int id; 
	private String namecolor;
	public Color() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamecolor() {
		return namecolor;
	}
	public void setNamecolor(String namecolor) {
		this.namecolor = namecolor;
	}
	public Color(int id, String namecolor) {
		super();
		this.id = id;
		this.namecolor = namecolor;
	}
	@Override
	public String toString() {
		return "Color [id=" + id + ", namecolor=" + namecolor + "]";
	}
	
	
}
