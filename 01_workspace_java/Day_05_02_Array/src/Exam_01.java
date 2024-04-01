import java.util.Scanner;

public class Exam_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열 생성 Step1. 참조변수 생성
		// int[] arr;

		// 배열 생성 Step.2 배열 생성
		// new int[4];// 힙 메모리를 사용하기 위한 키워드, 주소 값 반환

		// int[][] arr = new int[4][2]; // 2차원 배열
		// int[] arr = new int[]; // 배열선언 문법 1차원 배열

		// arr[0] = 5;
		// arr[1] = 10;
		// arr[2] = 15;
		// arr[3] = 20;
		// int a = 2;

		// System.out.println(arr[a]);

		// System.out.println(arr[(int) (Math.random() * 4)]);
		// System.out.println(arr[Integer.parseInt(sc.nextLine())]);

		// for (int i = 0; i < 4; i++) {
		// System.out.println(arr[i]);
		// }

		// int[] arr = new int[] { 5, 10, 15, 20 }; // 배열생성 문법 {}에 배열값 저장
		// 해당 방법은 초기값 지정[]은 안됨
		//

		// char형 변수 4개를 묶어 배열로 만들고 0 ~ 3번칸에 각 'A','B','C','D' 를 담아주세요.
		// 변수 이름은 arr1
		char[] arr1 = new char[] { 'A', 'B', 'C', 'D' };
		// for (int i = 0; i < arr1.length; i++) {
		// System.out.println(arr1[i]);
		// }
		System.out.println(arr1);

		// String형 변수 3개를 묶어 배열로 만들고. 0~2번 칸에 각 Hello Java Array를 담아주세요.
		// 변수이름은 arr2
		// String[] arr2 = new String[] { "Hello", "Java", "Array" };
		// for (int i = 0; i < arr2.length; i++) {
		// System.out.print(arr2[i]);
		// }

		// int형 변수 100개를 묶어 배열로 만들고, 0~99번간에 1~100까지를 담아주세요.
		// int[] arr3 = new int[100];
		// for (int i = 0; i < arr3.length; i++) {
		// System.out.println(arr3[i] = i + 1);
		// }
		// System.out.println(arr3[0]); // 1출력
		// System.out.println(arr3[99]); // 2출력

		// char형 변수 26개를 묶어 배열로 만들고, 0 ~ 25번칸에 'A'~'Z'까지를 담아주세요.
		// 변수이름은 arr4
		char[] arr4 = new char[26];
		// for (int i = 0; i < arr4.length; i++) {
		// arr4[i] = i + 65;
		// System.out.println((char) arr4[i]);
		// }
		for (int i = 0; i < arr4.length; i++) {
			arr4[i] = (char) (65 + i);
			// System.out.println(arr4[i]);
		}
		System.out.println(arr4[0]); // a
		System.out.println(arr4[25]); // z
	}
}
