
public class Exam_02 {
	public static void main(String[] args) {
		// 기본 8대 자료형
		// 정수형 : 숫자 저장 목적		
		// byte 범위 -128 ~ 127
		byte a = 127;
		// short 범위 -32768 ~ 32767 
		short b = 32767;
		// 문자로 전환 ASCII 
		char c = 12;
		// 정수형 대표 변수
		int d = 2100000000;
		// long complier 인식 오류로 인해 숫자 뒤 L( l로 표시 가능하나 1과 혼돈 야기 L대문자로 표기 관습 )로 명시
		long e = 1000000000000000000L;
		// 실수형 : 소수점 정밀체크 
		// double형으로 인식하기 때문에 인식오류 방지 차 f로 명시
		float f = 3.14f;
		double g = 5.12;
		System.out.println(c);
		// 논리형 : 참 거짓 구별 두 가지만 존재
		boolean h = true; // false
		// 참조형
		// 문자열 저장 변수
		String i = "Hello World";
	}
}
