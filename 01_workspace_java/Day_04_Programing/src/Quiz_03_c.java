import java.util.Scanner;

public class Quiz_03_c {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = (int) (Math.random() * 10 + 1);
		System.out.println(num);
		while (true) {
			int i = (int) (Math.random() * 10 + 1);
			System.out.println(i);
			int j = i;
			if (num > i) {
				i = (int) (Math.random() * (10 - j + 1) + j);
			} else if (num < i) {

			} else {
				break;
			}
		}
	}
//	난수 * (10 - 7 + 1)+7
}
