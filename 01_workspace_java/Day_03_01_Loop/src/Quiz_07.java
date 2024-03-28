import java.util.Scanner;

public class Quiz_07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bal = 3000;
		int coke = 0;
		int cider = 0;
		int plum = 0;
		int kp = 1200;
		int cp = 800;
		int pp = 1500;
		while (true) {
			System.out.println("==== 자판기 시뮬레이터 ====");
			System.out.println("1.콜라(1200) 2.사이다(800) 3.매실차(1500) [0.소지품확인]");
			System.out.print(">> ");
			int num = Integer.parseInt(sc.nextLine());
			// 콜라 구매 코드
			if (num == 1) {
				System.out.println("콜라 몇캔 구매하실건가요?");
				System.out.print(">> ");
				num = Integer.parseInt(sc.nextLine());
				if (bal >= (kp * (coke + num))) {
					coke += num;
					bal = bal - (kp * coke);
					System.out.println("콜라를 구매했습니다.");
					System.out.println("콜라 + " + coke);
					System.out.println("소지금 - " + (kp * coke));

				} else {
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 소지금 : " + bal);
				}
			} else if (num == 2) { // 사이다 구매 코드
				System.out.println("사이다 몇캔 구매하실건가요?");
				System.out.print(">> ");
				num = Integer.parseInt(sc.nextLine());
				if (bal >= (cp * (cider + num))) {
					cider += num;
					bal = bal - (cp * cider);
					System.out.println("사이다를 구매했습니다.");
					System.out.println("사이다 + " + cider);
					System.out.println("소지금 - " + (cp * cider));
				} else {
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 소지금 : " + bal);
				}
			} else if (num == 3) { // 매실차 구매 코드
				System.out.println("매실차 몇캔 구매하실건가요?");
				System.out.print(">> ");
				num = Integer.parseInt(sc.nextLine());
				if (bal >= (pp * (plum + num))) {
					plum += num;
					bal = bal - (pp * plum);
					System.out.println("매실차를 구매했습니다.");
					System.out.println("매실차 + " + plum);
					System.out.println("소지금 - " + (pp * plum));

				} else {
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 소지금 : " + bal);
				}
			} else if (num == 0) { // 소지품 확인 코드
				System.out.println("==== 나의 소지품 ====");
				System.out.println("소지금 : " + bal);
				System.out.println("콜라 : " + coke);
				System.out.println("사이다 : " + cider);
				System.out.println("매실 : " + plum);
				System.out.print(">> ");
			} else {
				System.out.println("번호를 제대로 입력해주세요!");
			}
			System.out.println("");
		}
	}
}
