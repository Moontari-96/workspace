public class Coding_Test_03 {
	public static void main(String[] args) {
//		int sum = 0;
		int[] numbers = new int[] { 1, 2, 3, 4, 6, 7, 8, 0 };
//		// 45
//		for (int i = 0; i < numbers.length; i++) {
//			sum += numbers[i];
//		}
//		System.out.println(sum - 45);
//		
		int sum = 45;
		for (int i : numbers) {
			sum -= i;
		}
		System.out.println(sum);
	}
}