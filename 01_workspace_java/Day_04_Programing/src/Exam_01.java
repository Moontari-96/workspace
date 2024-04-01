
public class Exam_01 {
	public static void main(String[] args) {
		// 난수 ( Random Number )
		// 사용자도 개발자도 예상할 수 없는 어떤 미지의 값
		// ex) 부루마블 게임의 주사위 또는 카드게임의 패 값 등…

		for (int i = 0; i < 10; i++) {
			double rand = Math.random(); // 랜덤으로 나오는 예상할 수 없는 double 값 하나.
			// 0 ~ 1 사이의 실수값
			// 1 ~ 6
			System.out.println((int) (rand * (72 - 34 + 1)) + 34);
		}
		// 34 ~ 72 사이의 난수
		// 난수 최대값 : y
		// 난수 최소값 : x
		// 난수 범위 조정 공식 : 난수 * (y-x+1)+x

	}
}
