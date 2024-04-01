
public class Exam_03 {
	public static void main(String[] args) {
		// Swap - 교환 기법
		// int A = 10;
		// int B = 20;
		// System.out.println(A + " : " + B);
		// int tmp = A; // tmpfile 임시파일
		// A = B;
		// B = tmp;
		// System.out.println(A + " : " + B);

		// Swap - 배열 교환 기법
		int[] arr = new int[] { 10, 20 };

		System.out.println(arr[0] + " : " + arr[1]);
		int tmp = arr[0];
		arr[0] = arr[1];
		arr[1] = tmp;
		System.out.println(arr[0] + " : " + arr[1]);

	}
}
