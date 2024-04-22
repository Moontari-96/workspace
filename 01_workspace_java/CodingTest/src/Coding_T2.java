
public class Coding_T2 {
	public static void main(String[] args) {
		String s = "abcde";
		String d = "qwer";
		System.out.println(d.substring(0, 3));
		String a = d.substring((d.length() - 1) / 2, d.length() / 2 + 1);
		System.out.println(a);
//		String answer = "";
//		int arr = 0;
//		char[] ch = d.toCharArray();
//		int a = ch.length;
//		if (ch.length % 2 == 0) {
//			arr = (ch.length / 2);
//			for (int i = arr - 1; i < arr + 1; i++) {
//				answer += ch[i];
//			}
//		} else if (ch.length % 2 == 1) {
//			arr = (ch.length / 2) + 1;
//			for (int i = arr - 1; i < arr; i++) {
//				answer += ch[i];
//			}
//		}

//		System.out.println(answer);

//		return answer;
	}
}
