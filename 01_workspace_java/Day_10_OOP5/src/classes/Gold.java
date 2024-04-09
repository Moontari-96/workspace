package classes;

public class Gold extends Member {
	public Gold() {
	}

	public Gold(String id, String name, int point) {
		super(id, name, point);
	}

	// override : 무효화 시킨다 / 메서드 재정의 / 메서드 오버라이딩 기법
	// Method Overriding : 상속받은 메서드를 임의의 내용으로 재정의해서 사용하는 문법
	public double getBonus() {
		return this.getPoint() * 0.03;
	}
	// 추상메서드 이용 시 내용을 채워넣으면 에러가 발생하지 않음
	// 내용을 채우지 않아도 될 시 추상 클래스로 변경하면 에러 발생 하지않음
	// 내용을 채우지 않으면 에러 발생으로 강제할 수 있음
	// Implementing 구현하는 기법 Overriding과 다른기법
}
