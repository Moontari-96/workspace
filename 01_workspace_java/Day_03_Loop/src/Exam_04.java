
public class Exam_04 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue; // 특정 조건일 때 코드 실행을 안하게 작동
			}
			System.out.println(i);
		}
	}
}
