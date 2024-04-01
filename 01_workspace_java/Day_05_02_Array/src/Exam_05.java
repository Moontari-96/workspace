
public class Exam_05 {
	public static void main(String[] args) {
		// Shuffle 알고리즘
		// 1 ~ 5 사이의 난수를 출력하세요.
		// 3개.
		// 중복 안되게요.
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 0; i < 50; i++) {
			int x = (int) (Math.random() * 5);
			int y = (int) (Math.random() * 5);
			int tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}
		System.out.println(arr[0] + " : " + arr[1] + " : " + arr[2]);
	}
}
