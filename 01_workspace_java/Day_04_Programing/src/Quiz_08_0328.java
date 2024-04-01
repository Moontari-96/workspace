import java.util.Scanner;

public class Quiz_08_0328 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=== 계산기 프로그램 ===");
			System.out.print("연산자입력 (+,-,*,/[q:종료]) : ");
			String oper = sc.nextLine();
			if (oper.equals("q")) {
				System.out.println("계산기를 종료합니다.");
				System.exit(0);
			} else if (oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
				System.out.print("첫 번째 수 : ");
				int num1 = Integer.parseInt(sc.nextLine());
				System.out.print("두 번째 수 : ");
				int num2 = Integer.parseInt(sc.nextLine());

				System.out.println("=== 결과 ===");
				if (oper.equals("+")) {
					System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
				} else if (oper.equals("-")) {
					System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
				} else if (oper.equals("*")) {
					System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
				} else if (oper.equals("/")) {
					System.out.println(num1 + " / " + num2 + " = " + ((double) num1 / num2));
				}
			} else {
				System.out.println("연산자를 다시 입력해주세요.");
			}

			System.out.println("");
		}

	}
}
