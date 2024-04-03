public class Quiz_06 {
	public static void main(String[] args) {
		// 비교할 두 배열 정의
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 3, 4, 5, 6, 7 };

		// 같은 값의 개수를 세기 위한 변수 초기화
		int count = 0;

		// array1의 각 요소를 기준으로 array2와 비교하여 같은 값이 있는지 확인
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					count++; // 같은 값이 있으면 count를 증가시킴
					break; // 같은 값이 발견되면 내부 루프 종료
				}
			}
		}

		// 결과 출력
		System.out.println("두 배열에서 같은 값의 개수: " + count);
	}
}
