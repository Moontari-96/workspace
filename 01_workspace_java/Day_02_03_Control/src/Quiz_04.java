import java.util.Scanner;

public class Quiz_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 국어 점수 변수 입력
		System.out.println("국어 점수를 입력하세요 :");
		int kor = Integer.parseInt(sc.nextLine());
		// 영어 점수 변수 입력
		System.out.println("영어 점수를 입력하세요 :");
		int eng = Integer.parseInt(sc.nextLine());
		// 수학 점수 변수 입력
		System.out.println("수학 점수를 입력하세요 :");
		int math = Integer.parseInt(sc.nextLine());
		// 평균 값 변수
		System.out.println("과학 점수를 입력하세요 :");
		int science = Integer.parseInt(sc.nextLine());
		// 평균 값 변수
		double avg = (kor + eng + math + science) / 4.0;
		// 평균 값에 따른 등급 조건
		String cls;
		if (avg >= 90) {
			cls = "A";
		} else if (avg >= 80) {
			cls = "B";
		} else if (avg >= 70) {
			cls = "C";
		} else if (avg >= 60) {
			cls = "D";
		} else {
			cls = "F";
		}
		// 결과 값 출력
		System.out.println("평균 점수 : " + avg + " / " + "등급 : " + cls);
	}
}