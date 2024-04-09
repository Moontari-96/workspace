package classes;

abstract public class Member {
	private String id;
	private String name;
	private int point;

	public Member() {
	}

	public Member(String id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}

	// public double getBonus() {
	// return point * 0.02;
	// }

	// abstract public class Member : abstract가 붙은 클래스는 instance를 생성하지못함.
	// 상속목적 클래스는 추상 클래스로 변경해도 무방함
	abstract public double getBonus();
	// 추상 메서드는 추상 클래스(abstract public class)와 같이 사용됨

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
