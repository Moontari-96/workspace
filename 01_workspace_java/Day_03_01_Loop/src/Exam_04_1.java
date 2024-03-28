public class Exam_04_1 {
	public static void main(String[] args) {
		int i;
		for (i = 1; i <= 10; i++) {
			if (i == 2 || i == 5) {
				continue;
			}
			System.out.println("i = " + i);
			if (i == 8) {
				break;
			}
		}
	}
}
