import java.util.Scanner;

public class Quiz_03_t {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int bestScore = 100; // 최고기록
		int score = 1; // 플레이 중인 기록

		while (true) {
			System.out.println("=== UP & Down Game ===");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. Quit Game");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				System.out.println("<< Game Start >>");
				int target = (int) (Math.random() * 100 + 1); // 맞추어야 하는 정답
				System.out.println("정답 : " + target);

				while (true) {
					System.out.print("Input Number : ");
					int player = Integer.parseInt(sc.nextLine()); // 플레이어의 시도

					if (player > target) {
						System.out.println("Down!!");
						score++;
					} else if (player < target) {
						System.out.println("Up!!");
						score++;
					} else {
						System.out.println("<< 정 답 >>");

						if (score < bestScore) {
							System.out.println("최고 기록 갱신입니다!!");
							bestScore = score;
						}
						score = 1; // 게임이 끝나는 시점에 현재 기록을 1로 reset
						break;
					}
				}
			} else if (menu == 2) {

				System.out.println("현재까지의 최고 기록은 " + bestScore + " 번 입니다.");

			} else if (menu == 3) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}

	}

}
