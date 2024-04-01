import java.util.Scanner;

// 동전 앞 뒤 맞추기 게임
public class Quiz_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("=== 동전 앞 뒤 맞추기 ===");

			// 랜덤 값 받기
			int coin = (int) (Math.random() * 2 + 1);
			// 사용자 숫자 입력란
			System.out.print("숫자를 입력해주세요 (1.앞면/2.뒷면)");
			int choose = Integer.parseInt(sc.nextLine());
			if (choose == 1 || choose == 2) {

				// 유효성 검사
				if (choose == coin) {
					System.out.println("맞췄습니다^^");
				} else {
					System.out.println("땡! 틀렸습니다!");
				}
				System.out.println("");
				System.out.println("------------------------------------>restart");
			} else {
				System.out.println("다시 골라주세요!");
			}
			System.out.println("");
		}
	}
}
