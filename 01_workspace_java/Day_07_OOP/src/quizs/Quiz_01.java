package quizs;

import classes.Car;

public class Quiz_01 {
	public static void main(String[] args) {
		// 1. Car 클래스 생성
		// 조건1. 멤버필드는 모델명 / 가격 / 색깔 3가지
		// 조건2. 정보은닉을 적용하여 제작할 것
		// 조건3. Getter/Setter 는 Global Convention에 따를 것
		// 조건4. Constructor 도 작성할 것.

		// 2. 생성된 클래스를 바탕으로 인스턴스 생성
		// 조건. 인스턴스를 생성할 때, 생성자 인자값으로
		// Genesis GV80 , 80 000 000, Gray 를 전달하여 생성할 것
		// 생성된 인스턴스의 모든 내용을 화면에 출력할 것.

		Car genesis = new Car("Genesis GV80", 80000000, new String[] { "Gray", "Blue", "Red" });
		System.out.println(genesis.getModel());
		System.out.println(genesis.getPrice());
		System.out.println(genesis.getColor());
	}
}
