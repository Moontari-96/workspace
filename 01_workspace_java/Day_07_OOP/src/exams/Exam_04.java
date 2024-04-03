package exams;

public class Exam_04 {

	// 자바에서는 메서드의 이름이 같아도 오직 매개변수를 통해 구분할 수 있다면, 다른 메서드로 사용할 수 있음.
	// 자바의 메서드 Overloading( 오버로딩 == 과적 ) 이라고 부른다.
	// 단, 메서드의 접근제한자, 반환값은 오버로딩에 영향을 줄 수 없다.

	public static void func() {
		System.out.println("Function 입니다.");
	}

	public static void func(int num1) {
		System.out.println("이건 다른 Function 입니다.");
	}

	public static void main(String[] args) {
		func();
		func(1);
	}
}
