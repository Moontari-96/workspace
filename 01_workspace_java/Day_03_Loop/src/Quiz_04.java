import java.util.Scanner;

public class Quiz_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 숫자를 입력받아 홀짝을 구분하는 프로그램을 3번 반복해보세요.

		int i = 0;
		while (i < 3) {
			System.out.print("1 ~ 100 사이 입력 : ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("====== 결 과 ======");
			// 조건 1 1 ~ 100 유효성 검사
			if (1 <= num && num <= 100) {
				// 조건 2 홀, 짝을 참 거짓 판단
				if ((num % 2) == 1) {
					System.out.println("입력한 수는 홀수 입니다.");
				} else {
					System.out.println("입력한 수는 짝수 입니다.");
				}
			} else {
				System.out.println("다시 입력하세요.");
			}
			i++;
			System.out.println();
		}
	}

}
