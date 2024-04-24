public class Coding_T4 {
	public static void main(String[] args) {
		String answer = "";
		String s1 = "3people unFollowed me";
		String s2 = " for the last week";
		String low_s = s2.toLowerCase();
		String[] arr = low_s.split(" ");
		for (String str : arr) {
			answer += str.substring(0, 1).toUpperCase() + str.substring(1) + " ";
		}
		if (s2.charAt(s2.length() - 1) != ' ') {
			answer = answer.substring(0, answer.length() - 1);
		}

		System.out.println(answer);
//		String answer = "";
//		String s = "3people unFollowed me";
//		String[] str = s.split(" ");
//		System.out.println(str.length);
//		for (String ss : str)
//			if (ss.length() > 0)
//				answer += ss.substring(0, 1).toUpperCase() + ss.substring(1).toLowerCase() + " ";
//			else
//				answer += " ";
//		if (s.charAt(s.length() - 1) != ' ')
//			answer = answer.substring(0, answer.length() - 1);
//		System.out.println(answer);
	}
}