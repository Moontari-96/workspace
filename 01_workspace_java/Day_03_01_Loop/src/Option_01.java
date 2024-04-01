import java.util.Scanner;

public class Option_01 {
	public static void main(String[] args) {
		// 1 ~ n 까지의 합 구하기
		Scanner sc = new Scanner(System.in);
		System.out.println("=== 1 ~ n 까지의 합 구하기 ===");
		// n 입력값 받기
		System.out.print("n 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		// 1 ~ n까지의 합을 담을 변수
		int sum = 0;
		// n까지 반복문을 통한 값 구하기
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("1 부터 n까지의 합은 " + sum);
	}
}
