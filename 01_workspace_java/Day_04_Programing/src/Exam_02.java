
public class Exam_02 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print("0 ~ 9까지의 랜덤 수 : ");
			System.out.print((int) (Math.random() * 10));
			System.out.println("");
			System.out.print("1 ~ 10까지의 랜덤 수 : ");
			System.out.print((int) (Math.random() * 10 + 1));
			System.out.println("");
			System.out.print("20 ~ 35까지의 랜덤 수 : ");
			System.out.print((int) (Math.random() * (35 - 20 + 1) + 20));
			System.out.println("");
			System.out.print("0 또는 1 : ");
			System.out.print((int) (Math.random() * 2));
			System.out.println("");
			System.out.println("");
		}
	}
}
