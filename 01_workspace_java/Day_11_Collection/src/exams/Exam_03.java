package exams;

import java.util.ArrayList;

public class Exam_03 {

	// Default 생성자
	// this

	public static void main(String[] args) {

		// 다형성
		// Object : 자바에 존재하는 모든 클래스타입의 최고 조상
		// 자바에 존재하는 모든 클래스는 Object를 상속 받게 되어있다.
		// 다형성은 필수적일 때를 제외하고는 사용을 자제하는 것이 좋다.
		// Object o = 10;
		// o = 3.14;
		// o = new Scanner(System.in);
		// o = new Exam_01();
		// Generic Type <> / 타입 지정
		ArrayList<String> arr = new ArrayList<>();

		arr.add("Hello");
		arr.add("World");
		arr.add("Java");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		arr.remove(0);
		System.out.println("===============");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));

		arr.add(1, "Collection");
		System.out.println("===============");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println("===============");
		System.out.println(arr.size());
	}
}
