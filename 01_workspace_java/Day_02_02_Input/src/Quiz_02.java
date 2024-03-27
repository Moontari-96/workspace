import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = sc.nextLine();
		System.out.println("국어 성적을 입력하세요.");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.println("영어 성적을 입력하세요.");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.println("수학 성적을 입력하세요.");
		int math = Integer.parseInt(sc.nextLine());
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		System.out.println("====================");
		System.out.println("이름 : " + name);
		System.out.println("====================");
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("====================");
		System.out.println("합 계 : " + sum);
		System.out.printf("평 균 : %.2f\n", avg);
		System.out.println("====================");
		sc.close();
	}
}
