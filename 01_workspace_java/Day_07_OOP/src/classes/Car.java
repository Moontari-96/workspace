package classes;

public class Car {
	private String model;
	private int price;
	private String[] color;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String[] getColor() {
		return color;
	}

	public void setColor(String[] color) {
		this.color = color;
	}

	public Car(String model, int price, String[] color) {
		this.model = model;
		this.price = price;
		this.color = color;
	}
}
