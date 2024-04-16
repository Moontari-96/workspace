
// static 
public class Exam_04 {

	public int a; // 인스턴스 멤버 필드, 인스턴스가 만들어져야지만 존재하는 변수
	public static int b; // 클래스 멤버 필드, static이 붙어있으면 메인이 실행됨과 동시에 같이 실행 됨. 전역 변수

	public void funcA() {
		a = 10;
		b = 10;
	}

	public static void funcB() {
		// a = 10; // static member method 내에서는 non-static 멤버를 사용할 수 없음.
		b = 10;
	}

	public static void main(String[] args) {
		// static 키워드가 붙은 코드는 main의 실행과 동시에 실행됨.
		// public static 이 함께 붙은 변수 또는 메서드는 언제 어디서나 접근이 가능하다.
		// static 키워드는 사용 빈도를 최소화 하는 것이 좋다. (꼭 필요한 곳에만 사용)
		// > 메모리 효율이 낮음.
		// > 멀티쓰레딩에 취약함.
		// 프로그램 전역에 걸쳐 사용되며, 언제 어디서나 접근이 쉬어야 하는 요소에 적용하면 좋다.

		// a = 10; // 오류
		// b = 10; // 가능
		// Exam_04.b = 10;

		Exam_04 e1 = new Exam_04();
		Exam_04 e2 = new Exam_04();
		e1.b = 10;
		System.out.println(e2.b);
		// a 인스턴스는 두개가 생성되지만 b는 static으로 공유됨

	}
}
