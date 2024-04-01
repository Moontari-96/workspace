public class Quiz_04 {
	public static void main(String[] args) {

		// 1 ~ 45 사이의 난수 6개를 중복없이 출력하세요.
		// 오늘의 로또 번호 입니다.
		int[] arr = new int[45];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < arr.length * 10; i++) {
			int x = (int) (Math.random() * 45);
			int y = (int) (Math.random() * 45);
			int tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}
		System.out.println(arr[0] + " : " + arr[1] + " : " + arr[2] + " : " + arr[3] + " : " + arr[4] + " : " + arr[5]
				+ " : " + arr[6]);
	}
}
