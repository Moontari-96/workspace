import java.util.Scanner;

public class Exam_01 {
	public static void main(String[] args) {

		// Checked Exception - 코딩과 동시에 문법 검사기에 의해 에러(예외)가 발생할 가능성을 바로 감지하는 종류
		// ex) System.in.read();

		// Unchecked Exception - 코딩 시점엔 문법검사기에게 감지되지 않다가 Runtime (실행 이후) 에 발생하는 종류
		// ex) Integer.parseInt(sc.nextLine()); <-- 이 코드에 문자 입력 시
		// For Input string 에러(예외) 발생

		// 예외에 대처할 수 있는 방법 두가지
		// 1. 예외 전가 - throws

		// 2. 예외 처리 - try~catch

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("숫자만 입력하세요 : ");
			Integer.parseInt(sc.nextLine()); // 에러(예외) 발생 예상 지점, 예외 처리 안할 시 메인 밖으로 탈출
			System.out.println("입력 확인");
		} catch (Exception e) {
			System.out.println("숫자만 입력하세요!"); // 에러(예외)시 진입루트
		}
		System.out.println("프로그램 정상 종료");
	}
}
