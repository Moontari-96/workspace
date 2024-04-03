import java.util.Scanner;

public class Quiz_04 {
	public static int validInput(String str) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		while (true) {
			try {
				System.out.print(str);
				input = Integer.parseInt(sc.nextLine());
				return input;
			} catch (Exception e) {
				System.out.println("숫자만 입력하세요!");
			}
		}
	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		int num1 = validInput("첫 번째 수 : ");
		int num2 = validInput("두 번째 수 : ");
	}
}
