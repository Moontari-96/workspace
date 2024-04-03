import java.util.Scanner;

public class Exam_01 {
	// 코드 진행 순서 main 부터
	// 사용자 정의 메서드
	public static int plus(int num1, int num2) { // 되돌려주는 DataType을 입력 / 메서드 본체( Prototype ) / 매개변수( Parameter ) /
													// callee method
		// {}안 명칭 메서드 구현부
		int result = num1 + num2;
		return result; // 반환하는 키워드 return 우측에 보내고자 하는 값 변수를 입력 / return 반환과 메서드 종료를 의미 / 값을 여러개 보낼순 없고
						// 단일만 보내지만 배열 사용 시 값을 여러개 보낼 수 있음
	}

	public static void main(String[] args) { // caller method
		Scanner sc = new Scanner(System.in);

		int result = plus(10, 5); // 실행됨과 동시 plus 메서드로 이동 / 메서드 종료 이후 다시 콜하던 시점으로 회귀 / 메서드 리턴값
		System.out.println(result); // 얘도 메서드 // 표준 메서드 // 라이브러리 내장 함수
		// sc.nextLine(); // return type string형 메서드

		// Integer.parseInt("10"); // return type int형 메서드
		// Math.random() // 매개변수가 없는 return type double형 메서드

		// 메서드를 사용하기 위해 부르는 문법을 Method Call 이라고 부른다.
		// 메서드 콜 시점에 소괄호내에 전달하는 값을 인자값 (Argument) 라고 부른다.
		// > 인자값은 인수값 또는 parameter라고 불리기도 한다.

		// 메서드 본체 ( Prototype ) 에서 인자값을 전달받기 위해 선언된 변수를 매개 변수라고 부른다.
		// main 메서드가 plus 메서드를 call 했을 때, main 이 caller method, plus가 callee method
	}
}
