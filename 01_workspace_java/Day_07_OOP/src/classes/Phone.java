package classes;

import java.util.Scanner;

public class Phone {
	int price;
	double weight;
	double inch;
	String color;
	int bright;

	void powerOn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("전원을 끄시겠습니까? 예 또는 아니오로 대답해주세요.");
		while (true) {
			try {
				String on = sc.nextLine();
				if (on.equals("예")) {
					System.out.println("전원을 종료합니다.");
					break;
				} else if (on.equals("아니오")) {
					System.out.println("예 알겠습니다.");
					break;
				}
			} catch (Exception e) {
				System.out.println("예 또는 아니오로 대답해주세요.");
			}
		}

	}

	void powerOff() {
	}

	void brightness() {
	}

	void touch() {
	}

	void call() {
	}

}
