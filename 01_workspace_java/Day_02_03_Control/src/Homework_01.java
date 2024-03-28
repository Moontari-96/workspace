import java.util.Scanner;

public class Homework_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("축잘알 테스트를 시작합니다. 아래 질문에 대해 '1' 또는 '2'로 답하세요.");
		// 총 점수
		int score = 0;
		// 질문과 답변 처리
		System.out.print("1. 손흥민이 뛰고 있는 팀은 토트넘이다. (1. 예 / 2. 아니오): ");
		int answer1 = Integer.parseInt(sc.nextLine());
		if (answer1 == 1) {
			score += 20;
		}
		System.out.print("2. 이강인이 뛰고 있는 팀은 파리바게트다. (1. 예 / 2. 아니오): ");
		int answer2 = Integer.parseInt(sc.nextLine());
		if (answer2 == 2) {
			score += 20;
		}
		System.out.print("3. 모하메드 살라는 리버풀 선수가 맞다. (1. 예 / 2. 아니오): ");
		int answer3 = Integer.parseInt(sc.nextLine());
		if (answer3 == 1) {
			score += 20;
		}
		System.out.print("4. 김민재가 현재 뛰고 있는 팀은 나폴리다. (1. 예 / 2. 아니오): ");
		int answer4 = Integer.parseInt(sc.nextLine());
		if (answer4 == 2) {
			score += 20;
		}
		System.out.print("5. 리버풀은 세계 최고의 클럽이다. (1. 예 / 2. 아니오): ");
		int answer5 = Integer.parseInt(sc.nextLine());
		if (answer5 == 1) {
			score += 100;
		} else {
			score -= 100;
		}

//		// 결과 출력
		System.out.print("축잘알 테스트 결과: ");
		if (score >= 80) {
			System.out.println("당신은 축잘알이시군요 👍👍");
		} else {
			System.out.println("알못 중에 알못 축알못 👎👎");
		}

	}
}
