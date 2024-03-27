import java.util.Scanner;

public class Quiz_01 {
	public static void main(String[] args) {
// 		두개의 정수를 입력받아, 덧셈한 결과를 출력하는 프로그램을 작성하세요.
//		UI에 신경 써서 만들어주세요.

		Scanner sc = new Scanner(System.in); // 문자열 입력을 위한 도구를 준비한다.

		System.out.println("첫번째 값을 입력해주세요."); // 사용자가 보게될 안내메시지를 출력한다.
		String str1 = sc.nextLine();
		int num1 = Integer.parseInt(str1);
		// 사용자가 입력한 값을 숫자로 변환하여 변수에 보관한다.

		System.out.println("두번째 값을 입력해주세요.");
		String str2 = sc.nextLine();
		int num2 = Integer.parseInt(str2);

		System.out.println("첫번째 값 " + num1 + " 두번째 값 " + num2 + "의 합은 " + (num1 + num2) + "입니다.");
		// 보관 된 두개의 수를 덧셈하여 화면에 출력한다.

//		다른 풀이
//		System.out.print("첫 번째 수 : ");
//		int num1 = Integer.parseInt(sc.nextLine());
//
//		System.out.print("두 번째 수 : ");
//		int num2 = Integer.parseInt(sc.nextLine());
//
//		System.out.println("입력하신 두 수의 합 : " + (num1 + num2));

		sc.close();
	}
}
