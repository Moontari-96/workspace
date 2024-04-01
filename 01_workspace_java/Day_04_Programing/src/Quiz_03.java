import java.util.Scanner;

// UP & Down Game
// 1~ 99까지 범위의 랜덤한 숫자를 맞추는 게임
// 전체적인 메뉴는 switch-case문으로 만들 것
// score는 맞추는 횟수
// level 2는 경쟁상대를 만들어서 진행
public class Quiz_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int max = 0;
		while (true) {
			int rand = (int) (Math.random() * 10 + 1);
			int player = 0;
			System.out.println("== UP & Down Game ==");
			System.out.println("1. Game Start");
			System.out.println("2. Game score");
			System.out.println("3. End Game");
			System.out.println("");
			System.out.print(">");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				sum = 1;
				while (true) {
					System.out.println("<< Game Start >>");
					System.out.println("Input Number : ");
					player = Integer.parseInt(sc.nextLine());
					if (player < rand) {
						System.out.println("<< UP >>");
						sum++;
					} else if (player > rand) {
						System.out.println("<< DOWN >>");
						sum++;
					} else {
						System.out.println("<< 정 답 >>");
						break;
					}
				}
				break;
			case 2:
				System.out.println("<< Game Score >>");
				max = sum;
				if (sum < max || sum == 0) {
					System.out.println("플레이어의 점수는 : " + sum + "입니다.");
				} else {
					System.out.println("플레이어의 최고 점수는 : " + max + "입니다.");
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다!");
				System.exit(0);
				break;
			default:
				System.out.println("선택지를 다시 선택해주세요");
			}
			System.out.println("");
		}
	}
}
