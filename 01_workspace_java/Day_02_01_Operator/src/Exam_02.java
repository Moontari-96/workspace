
public class Exam_02 {
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		boolean result;
		int result2;
		result2 = x + y;	//	10 + 20 = result2
		System.out.println(x + " + " + y + " = " + result2);
		x = y = 2;	// x = 2, y = 2;
		System.out.println("x = " + x++ + ", y = " + ++y); // 전치형 증감자 y = 3 후치형 증감자 x = 2
		System.out.println("x = " + x + ", y = " + y); // 전치형 증감자 y = 3 후치형 증감자 x = 3
		y = 10;
		result  = !(((x > y) || (y == x)) || ((x != y) && (x < y)));
		System.out.println(result);
	}
}
