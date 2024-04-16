import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam_03 {
	public static void main(String[] args) throws Exception {

		// String -> Timestamp

		String ctime = "2014-04-15";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Date 타입 사용
		Date result = sdf.parse(ctime); // 분석 실패 할 가능성 -> throws 예외 전가
		// 후에는 import sql을 사용하지만 우선 util
		long parsedTime = result.getTime();
		System.out.println(parsedTime);
		// 2014.04.15
		// 2014년 4월 15일

		// 재변환 과정
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E)");
		String result2 = sdf2.format(parsedTime);
		System.out.println(result2);
	}
}
