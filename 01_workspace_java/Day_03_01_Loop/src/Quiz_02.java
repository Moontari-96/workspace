
public class Quiz_02 {
	public static void main(String[] args) {
		int count = 0;
		while (count < 100) {
			count++;
			System.out.print(count + " ");
			if (count % 10 == 0) {
				System.out.println();
			}
		}
	}
}
