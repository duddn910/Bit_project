package DTO;

public class CoffeeDTO {
	
	private String Name;
	private int Short;
	private int Tall;
	private int Grande;
	
	public CoffeeDTO() {
		
	}

	public CoffeeDTO(String name, int s, int tall, int grande) {
		Name = name;
		Short = s;
		Tall = tall;
		Grande = grande;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getShort() {
		return Short;
	}

	public void setShort(int s) {
		Short = s;
	}

	public int getTall() {
		return Tall;
	}

	public void setTall(int tall) {
		Tall = tall;
	}

	public int getGrande() {
		return Grande;
	}

	public void setGrande(int grande) {
		Grande = grande;
	}

	@Override
	public String toString() {
		return "CoffeeDTO [Name=" + Name + ", Short=" + Short + ", Tall=" + Tall + ", Grande=" + Grande + "]";
	}
	
}
