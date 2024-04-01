import java.util.Scanner;

public class Quiz_06 {
	public static void main(String[] args) {
//		* 코드 작성에 필요한 변수는 최상단에 위치한다.
//		System.exit(0); // 프로그램을 즉시 종료시키는 코드
		Scanner sc = new Scanner(System.in);
		int chk = 3000; // 잔액 변수
		int inp; // 출입금 변수
		int num; // 번호 선택 변수

		while (true) {
			System.out.println("*** ATM 시뮬레이터 ***");
			System.out.println("1. 잔액조회");
			System.out.println("2. 입급하기");
			System.out.println("3. 출금하기");
			System.out.println("4. 종료하기");
			System.out.print(">> ");
			while (true) {
				try {
					num = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
				}
			}

			if (num == 1) {
				System.out.println("현재 보유잔액은 " + chk + "입니다.");
			} else if (num == 2) {
				System.out.println("얼마를 입급 하시겠습니까?");
				System.out.print(">> ");
				while (true) {
					try {
						inp = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("숫자만 입력해주세요.");
					}
				}
				System.out.println(inp + "원이 입금되었습니다.");
				chk += inp; // 기존 잔액과 입급 금액을 합쳐서 보관
			} else if (num == 3) {
				System.out.println("얼마를 출금 하시겠습니까?");
				System.out.print(">> ");
				while (true) {
					try {
						inp = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("숫자만 입력해주세요.");
					}
				}
				if (chk >= inp) {
					System.out.println(inp + "원이 출금되었습니다.");
					chk -= inp; // 기존 잔액과 출금 금액을 빼서 보관
				} else {
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 보유잔액은 " + chk + "입니다.");
				}
			} else if (num == 4) {
				System.out.println("거래를 종료합니다.");
				System.exit(0); // 프로그램을 즉시 종료시키는 코드
			} else {
				System.out.println("번호를 재입력 해주세요.");
			}
			System.out.println("");
		}
	}

}
