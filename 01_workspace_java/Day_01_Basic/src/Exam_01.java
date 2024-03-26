import java.lang.*; // 생략 가능 임포트 폴더 lang 제외 import 필수 

// Coding Convention (관습/관례)
// 1. {} 작성법 / 범위 - Team
//문법
//{
//	// BSD Style
//}

//문법 
//	{
//	// GNU Style
//	}
//
//문법 {
//	// K&R Style
//}

// 2. 클래스 이름 첫글자는 반드시 대문자 / 범위 - Global

public class Exam_01 { // 파일명과 똑같이 

	public static void main(String[] ar) { // 초기 실행위치 
	
		System.out.println("Hello World"); // 텍스트 출력, ; 문법구분자
		System.out.println(1234);
		System.out.print(3.14);
		System.out.println('A');
		
		System.out.println(5+10);
		System.out.println("5" + "10");
		// 데이터 유형 구분짓기 위해 사용하는 기호
		// 문자열을 다룰 때에는 Double Quote (쌍따옴표) 를 사용한다.
		// 단일 문자를 다룰 때에는 Single Quote (홑따옴표) 를 사용한다.
		// 숫자 데이터를 다룰 때에는 quote를 사용하지 않는다.
	}
} // 영역 지정 

