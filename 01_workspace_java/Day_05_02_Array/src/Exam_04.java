
public class Exam_04 {
	public static void main(String[] args) {
		// Buble sort
		int[] arr = new int[] { 97, 63, 57, 21 };

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		System.out.println("===== 정렬 전");

//		if (arr[0] > arr[1]) {
//			tmp = arr[0];
//			arr[0] = arr[1];
//			arr[1] = tmp;
//		}
//		if (arr[1] > arr[2]) {
//			tmp = arr[1];
//			arr[1] = arr[2];
//			arr[2] = tmp;
//		}
//		if (arr[2] > arr[3]) {
//			tmp = arr[2];
//			arr[2] = arr[3];
//			arr[3] = tmp;
//		}

		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		System.out.println("===== 정렬 후");
	}
}
