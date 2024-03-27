import java.util.Scanner;

public class Quiz_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("1 ~ 100 사이 입력 : ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("====== 결 과 ======");
			if (1 <= num && num <= 100) {
				// 조건 2 홀, 짝을 참 거짓 판단
				if ((num % 2) == 1) {
					System.out.println("입력한 수는 홀수 입니다.");
					break;
				} else {
					System.out.println("입력한 수는 짝수 입니다.");
					break;
				}
			} else {
				System.out.println("다시 입력하세요.");
			}
		}

//		public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("1 ~ 100 사이 입력 : ");
//		int num = Integer.parseInt(sc.nextLine());
//		System.out.println("====== 결 과 ======");
//		if ((1 <= num && num <= 100) && (num % 2) == 1) {
//			System.out.println("입력한 수는 홀수 입니다.");
//		} else if ((1 <= num && num <= 100) && (num % 2) == 0) {
//			System.out.println("입력한 수는 짝수 입니다.");
//		} else {
//			System.out.println("다시 입력하세요.");
//		}
//	}

//		public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("1 ~ 100 사이 입력 : ");
//		int num = Integer.parseInt(sc.nextLine());
//		System.out.println("====== 결 과 ======");
//		if (1 > num || num > 100) {
//			System.out.println("다시 입력하세요.");
//		} else if ((num % 2) == 0) {
//			System.out.println("입력한 수는 짝수 입니다.");
//		} else {
//			System.out.println("입력한 수는 홀수 입니다.");
//		}
//	}

	}
}
