package classes;

public class Product {
	private int code;
	private String productName;
	private int price;
	private int inventory;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public Product() {
	}

	public Product(int code, String productName, int price, int inventory) {
		this.code = code;
		this.productName = productName;
		this.price = price;
		this.inventory = inventory;
	}
}
