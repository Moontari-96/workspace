import java.text.SimpleDateFormat;

public class Exam_02 {
	public static void main(String[] args) {
		// Timestamp -> String(형식을 갖춘...)

		long ctime = System.currentTimeMillis(); // 현재 Timestamp 추출

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd(E) hh:mm:ss"); // 어떤 형식으로 보여줄지 결정
																				// (월은 M(대문자) 분(minute)은m(소문자)), (E)는 요일

		String result = sdf.format(ctime); // Timestamp를 형식에 맞게 반환하는 메서드 호출

		System.out.println("결과 : " + result);
	}
}
