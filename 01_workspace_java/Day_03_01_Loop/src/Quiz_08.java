import java.util.Scanner;

public class Quiz_08 {
	public static void main(String[] args) {
//		q 누르고 enter 누르면 프로그램 종료
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;

		while (true) {
			System.out.println("===== 계산기 프로그램 =====");
			System.out.print("연산자 입력 (+,-,*,/,[q:종료]) : ");
			String oper = sc.nextLine();
			if (oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
				while (true) {
					try {
						System.out.print("첫 번째 숫자 입력 : ");
						num1 = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("숫자만 입력 가능합니다.");
					}
				}
				while (true) {
					try {
						System.out.print("두 번째 숫자 입력 : ");
						num2 = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("숫자만 입력 가능합니다.");
					}
				}
				System.out.println("===== 결과 =====");
				if (oper.equals("+")) {
					System.out.println(num1 + " " + oper + " " + num2 + " = " + (num1 + num2));
				} else if (oper.equals("-")) {
					System.out.println(num1 + " " + oper + " " + num2 + " = " + (num1 - num2));
				} else if (oper.equals("*")) {
					System.out.println(num1 + " " + oper + " " + num2 + " = " + (num1 * num2));
				} else if (oper.equals("/")) {
					System.out.println(num1 + " " + oper + " " + num2 + " = " + ((double) (num1 / num2)));
				}
			} else if (oper.equals("q")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
			System.out.println("");
		}

	}
}
