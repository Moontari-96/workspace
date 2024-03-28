import java.util.Scanner;

public class Quiz_05 {
	public static void main(String[] args) {
//		구구단 출력 프로그램 만들기
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("=== 구구단 출력 프로그램 ===");
			// 구구단 입력 값 받기
			System.out.print("2 ~ 9단 중  선택 : ");
			int count = Integer.parseInt(sc.nextLine());
			// 구구단 초기식
			int i = 1;
			if (2 <= count && count < 10) {
				// 구구단 루프식
				while (i < 10) {
					// 구구단 출력
					System.out.println(count + " * " + i + " = " + count * i);
					i++;
				}
				break;
			} else {
				System.out.println("범위를 벗어났습니다. 다시 입력하세요.");
			}
		}

	}
}
