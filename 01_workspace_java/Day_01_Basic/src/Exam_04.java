
public class Exam_04 {
	public static void main(String[] args) {
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		
		/*1*/ b = (byte)i;
		/*2*/ ch = (char)b;
		/*3*/ short s = (short)ch;
		/*4*/ float f = (float)l;
		/*4*/ f = l;
		/*5*/ i = (int)ch;
		/*5*/ i = ch;
	}
}
