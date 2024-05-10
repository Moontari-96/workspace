import java.util.Arrays;

public class Coding_Test_03 {
	public static void main(String[] args) {
		int[] answer = {};
		int[] arr = new int[] { 4, 3, 2, 1 };
		Integer[] desc = {};
		Arrays.sort(arr);
		if (arr.length == 1) {
			int[] answer = { -1 };
			return answer;
		}
		int[] answer = new int[arr.length - 1];
		int minIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[minIndex] > arr[i]) {
				minIndex = i;
			}
		}
		for (int i = minIndex + 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr[i];
		}
//		return answer;

	}

//	public int[] solution(int[] arr) {
//
//	}
};
