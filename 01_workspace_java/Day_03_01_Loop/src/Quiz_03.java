import java.util.Scanner;

public class Quiz_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello를 몇번 출력하시겠습니까?");
		// 사용자에게 반복 횟수를 받는 부분
		int num = Integer.parseInt(sc.nextLine());
		int count = 0;

		while (count < num) {
			count++;
			System.out.println("Hello");
		}
	}
}
