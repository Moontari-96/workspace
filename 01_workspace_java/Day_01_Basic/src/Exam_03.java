
public class Exam_03 {
	public static void main(String[] args) {
		//	Data type Promotion
		byte a = 10;
		short b = 0;
		b = a; 
		System.out.println(b);
		//	정수형 실수형 프로모션 형변형 예시
		System.out.println(3/2.0);
		//	System.out.println(3.0/2.0);
		//	String type 프로모션 형변형 예시 문자열 방지를 위한()연산
		System.out.println("두 수의합 : " + (10 + 5));
		//	Data type Casting			
		byte c = 0;
		short d = 10;
		
		c = (byte)d;
		System.out.println(c);
	}
}
