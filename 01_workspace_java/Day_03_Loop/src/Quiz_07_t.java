import java.util.Scanner;

public class Quiz_07_t {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = 30000; // 기본 소지금
		int coke = 0; // 가진 콜라 개수
		int cider = 0; // 가진 사이다 개수
		int plumtea = 0; // 가진 매실차 개수

		while (true) {
			System.out.println("=== 자판기 시뮬레이터 ===");
			System.out.println("1. 콜라 (1200)");
			System.out.println("2. 사이다 (800)");
			System.out.println("3. 매실차 (1500)");
			System.out.println("4. 종료하기");
			System.out.println("[0. 소지품 확인]");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {

				if (money >= 1200) {
					System.out.println("콜라를 구매합니다.");
					System.out.println("소지금 - 1200");
					System.out.println("콜라 + 1");
					money -= 1200;
					coke++;
				} else {
					System.out.println("돈이 부족합니다.");
					System.out.println("현재 잔액 : " + money);
				}

			} else if (menu == 2) {

				if (money >= 800) {
					System.out.println("사이다를 구매합니다.");
					System.out.println("소지금 - 800");
					System.out.println("사이다 + 1");
					money -= 800;
					cider++;
				} else {
					System.out.println("돈이 부족합니다.");
					System.out.println("현재 잔액 : " + money);
				}

			} else if (menu == 3) {

				if (money >= 1500) {
					System.out.println("매실차를 구매합니다.");
					System.out.println("소지금 - 1500");
					System.out.println("매실차 + 1");
					money -= 1500;
					plumtea++;
				} else {
					System.out.println("돈이 부족합니다.");
					System.out.println("현재 잔액 : " + money);
				}

			} else if (menu == 4) {
				System.out.println("시뮬레이터를 종료합니다.");
				System.exit(0);
			} else if (menu == 0) {
				System.out.println("[ 현재 소지품 목록 ]");
				System.out.println("소지금 : " + money);
				System.out.println("콜라 : " + coke);
				System.out.println("사이다 : " + cider);
				System.out.println("매실차 : " + plumtea);
			} else {
				System.out.println("메뉴를 다시 확인해주세요.");
			}
		}

	}
}
