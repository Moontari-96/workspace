import java.util.Scanner;

public class Exam_08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("과일");
		String fruits = sc.nextLine();

		// String type 데이터간의 비교는 equals를 사용한다.

		if (fruits.equals("Apple")) {
			System.out.println("Apple은 사과입니다.");
		} else {
			System.out.println("다른 단어는 모르오.");
		}
	}
}
