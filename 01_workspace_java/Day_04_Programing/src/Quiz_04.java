import java.util.Scanner;

public class Quiz_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bal = 0;
		int charge = 0;
		int menu = 0;
		int stake = 0;
		int choice = 0;

		while (true) {
			while (true) {
				try {
					System.out.println("경마게임에 오신 것을 환영합니다.");
					System.out.println("1. 게임 시작");
					System.out.println("2. 잔액 충전");
					System.out.println("3. 잔액 조회");
					System.out.println("4. 종료");
					System.out.print(">>");
					menu = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
					System.out.println("");
				}
			}
			exit: if (menu == 1) {
				int target = (int) (Math.random() * 3 + 1);
				System.out.println(target);
				System.out.println("말들이 준비 되었습니다. 배팅하고 싶은 말을 선택해주세요.");
				System.out.println("1번말 : 우승경력이 많지만 은퇴시기를 앞둔 늙은말");
				System.out.println("2번말 : 2월달 연습 기록이 가장 좋았던 젊은말");
				System.out.println("3번말 : 떠오르는 신예 말");
				System.out.print(">>");
				while (true) {
					try {
						choice = Integer.parseInt(sc.nextLine());
						System.out.println(choice + "번 말을 선택하셨습니다.");
						break;
					} catch (Exception e) {
						System.out.println("숫자만 입력해주세요.");
					}
				}
				while (true) {
					while (true) {
						try {
							System.out.println("얼마를 베팅하시겠습니까 ??");
							System.out.print(">>");
							stake = Integer.parseInt(sc.nextLine());
							break;
						} catch (Exception e) {
							System.out.println("숫자만 입력해주세요.");
						}
					}
					if (stake <= bal) {
						if (choice == target) {
							System.out.println("베팅한 " + choice + "번 말이 승리하였습니다!!");
							System.out.println("베팅액의 50%를 받았습니다!");
							bal += (stake / 2);
							System.out.println("현재 잔액은 " + bal + "원 입니다.");
							break;
						} else {
							System.out.println("아 .... 안타깝습니다." + target + "번 말이 승리하였습니다.");
							bal -= stake;
							System.out.println(stake + "원 만큼 잃으셨습니다. 안타깝습니다. 현재잔액은" + bal + "원 입니다.");
							break;
						}
					} else {
						System.out.println("잔액이 부족합니다.");
						System.out.println("현재 잔액은 " + bal + "원 입니다.");
						break exit;
					}
				}
			} else if (menu == 2) {
				while (true) {
					try {
						System.out.println("얼마를 충전하시겠습니까?");
						System.out.print(">>");
						charge = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("숫자만 입력해주세요.");
					}
				}
				System.out.println(charge + "만큼 충전되었습니다.");
				System.out.print("현재 잔액은 다음과 같습니다  :");
				System.out.println((bal += charge) + " 원");
			} else if (menu == 3) {
				System.out.println("현재 잔액은 다음과 같습니다 : " + bal + " 원");
			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("번호를 재입력 해주세요.");
			}
			System.out.println("");
		}
	}
}
