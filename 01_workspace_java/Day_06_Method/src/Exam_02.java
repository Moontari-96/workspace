
public class Exam_02 {
	public static void main(String[] args) {
		// 문자열 길이
		String str = "Hello Java World";
		int result = str.length();
		System.out.println(result);

		// 문자열 인덱스 값으로 한글자 뽑아내기
		char result1 = str.charAt(1);
		System.out.println(result1);

		// 문장이 내가 원하는 단어로 시작하는지 검사하는 용도로 사용하는 함수(메서드)
		boolean result2 = str.startsWith("Hell");
		System.out.println(result2);

		// 문장이 내가 원하는 단어로 끝나는지 검사하는 용도로 사용하는 함수(메서드)
		boolean result3 = str.endsWith("lo");
		System.out.println(result3);

		// 문자열 안에 Java 라는 단어가 포함되어있는지 확인하고 싶다면?
		boolean result4 = str.contains("Java");
		System.out.println(result4);

		// 문자열 한 글자로 나누기
		String str2 = "ABCDE";
		char[] arr = str2.toCharArray();
		System.out.println(arr[0] + " : " + arr[1]);

		// 문자열 쪼개기 및 기준문자 삭제
		String str3 = "Apple#Orange#Strawberry";
		String[] arr2 = str3.split("#");
		System.out.println(arr2[2]);
	}
}
