
public class Quiz_02 {
	public static int countA(String str) {
		int count = 0;
		// charAt 사용 방법
		// for (int i = 0; i < str.length(); i++) {
		// char ch = str.charAt(i);
		// if (ch == 'A') {
		// count++;
		// }
		// }
		// toCharArray 사용 방법
		for (int i = 0; i < str.length(); i++) {
			char[] ch = str.toCharArray();
			if (ch[i] == 'A') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "ABCDEAAAAAECG";
		int count = countA(str);
		System.out.println(count); // A의 개수가 출력

	}
}
