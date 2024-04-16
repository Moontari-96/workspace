import java.text.SimpleDateFormat;
import java.util.Date;

public class Quiz_01 {
	public static void main(String[] args) throws Exception {
		// 1919년 3월 1일은 무슨 요일이었을까요?

		String before = ("1919.03.01");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date change = sdf.parse(before);

		long result = change.getTime();

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd(E)");
		String result2 = sdf2.format(result);
		System.out.println(result2);
	}
}
