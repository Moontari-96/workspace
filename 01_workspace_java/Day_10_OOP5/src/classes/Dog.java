package classes;

public class Dog extends Animal {
	public Dog() {
	}

	public Dog(String name) {
		super(name);
	}

	public String sound() {
//		System.out.println(this.getName() + " : " + "BowWow");
		return "BowWow";
	}
}
