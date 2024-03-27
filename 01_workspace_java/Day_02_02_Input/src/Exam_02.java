import java.util.Scanner; // ctrl + shift + o = Auto Import
// 문자열을 입력받기 위해 필요한 라이브 러리 도구

public class Exam_02 {
	public static void main(String[] args) {
		// 문자열 또는 큰 숫자를 입력받는 방법.
		Scanner sc = new Scanner(System.in); // 도구를 준비한다
		System.out.println("메모를 남겨주세요.");
//		String str = sc.nextLine(); // next line 도구를 사용하겠다., 아직 정해지지 않은 문자열 값, 입력한 값을 return Type은 string
//		// 개발단계 compile time, 실행 단계 Runtime
//		int num = Integer.parseInt(str); // 입력받은 문자열을 숫자로 변환하는 코드
//		System.out.println(num + 100);
		int num = Integer.parseInt(sc.nextLine());
		System.out.println(num + 100);
		sc.close();
	}
}
