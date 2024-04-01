import java.util.Scanner;

public class Quiz_03_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean playerTurn = true; // 턴나누기
		int guess = 0;
		while (true) {
			System.out.println("=== UP & Down Game ===");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. Quit Game");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				System.out.println("<< Game Start >>");
				int target = (int) (Math.random() * 10 + 1); // 맞추어야 하는 정답
				System.out.println("정답 : " + target);
				while (true) {
					System.out.print("Input Number : ");
					if (playerTurn) {
						int player = Integer.parseInt(sc.nextLine()); // 플레이어의 시도
						if (player > target) {
							System.out.println("Down!!");
						} else if (player < target) {
							System.out.println("Up!!");
						} else {
							System.out.println("<< 정 답 >>");
							// 게임이 끝나는 시점에 현재 기록을 1로 reset
							break;
						}
						playerTurn = false;
					} else {
						int com = (int) (Math.random() * 10 + 1); // 컴퓨터의 시도
						System.out.println(com);
						if (com > target) {
							com = (int) (Math.random() * (10 - com + 1) + com);
							System.out.println("Down!!");
						} else if (com < target) {
							com = (int) (Math.random() * (10 - com + 1) + com);
							System.out.println("Up!!");
						} else {
							System.out.println("<< 정 답 >>");
							// 게임이 끝나는 시점에 현재 기록을 1로 reset
							break;
						}
						playerTurn = true;
					}
				}
			} else if (menu == 2) {
				if (playerTurn) {
					System.out.println("플레이어가 승리했습니다!");
				} else {
					System.out.println("컴퓨터가 승리했습니다!");
				}
			} else if (menu == 3) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}

	}
}
