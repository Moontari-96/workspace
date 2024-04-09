package exams;

class A {
	public void funcA() {
		System.out.println("A 클래스 메서드 입니다.");
	}
}

class B extends A {
	public void funcB() {
		System.out.println("B 클래스 메서드 입니다.");
	}
}

//class C extends B {
//}

public class Exam_01 {
	public static void main(String[] args) {

		// 다형성 - 많을 다 / 형상 형 / 성질
		// 형상이 많은 성질?
		// is - a 상속관계 놓인 두 클래스 중, 부모클래스 참조변수에 발현되는 성질
		// 상속관계의 클래스 관계에서 부모클래스의 참조변순느 자식을 상속받는
		// 자식클래스 인스턴스의 주소를 저장할 수 있는 성질

		// 부모 클래스 참조변수에 자식클래스 인스턴스의 주소를 저장했을 때,
		// 기본적으로 참조변수의 타입만큼만 접근 가능하다.
		// 만약 저장된 인스턴스의 모든 것을 사용해야 한다면, DownCasting이 필요하다.

		// 예외 사항 : 다운캐스팅 없이 사용 가능한 메서드도 존재함.
		// **대상은 Overriding, Implementing 된 메서드**

		A a = new A();
		a = new B(); // Up Casting 형변환 ( 기본타입 : 프로모션 )
		a.funcA();
		((B) a).funcB(); // Down Casting 형변환
		// a = new C();

	}
}
