package Model;

public class Size {
	private int id;
	private String name;

	public Size(int id, String name) {
		;
		this.id = id;
		this.name = name;
	}

	public Size(String name) {
		this.name = name;
	}

	public Size() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
