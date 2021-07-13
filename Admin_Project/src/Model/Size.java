package Model;

public class Size {
	private int id;
	private String namesize;
	public Size() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamesize() {
		return namesize;
	}
	public void setNamesize(String namesize) {
		this.namesize = namesize;
	}
	public Size(int id, String namesize) {
		super();
		this.id = id;
		this.namesize = namesize;
	}
	@Override
	public String toString() {
		return "Size [id=" + id + ", namesize=" + namesize + "]";
	}
	
	
}
