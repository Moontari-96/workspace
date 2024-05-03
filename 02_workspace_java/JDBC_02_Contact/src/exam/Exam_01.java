package exam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exam_01 {
	public static void main(String[] args) throws Exception {
		
		// DBMS 테이블에 날짜 컬럼을 Timestamp로 지정했다는 전제하에 예제
		// 사용자 날짜 입력 (String) -> Timestamp ( or Date ) 으로 변환
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("날짜 입력 (년도/월/일) : ");
		String inputDate = sc.nextLine();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		Date parsed = sdf.parse(inputDate);
		
		// Date 타입으로 사용할 때 util.Date를 임포트 했기 때문에 java.sql.Date 풀 네임 작성 후 사용
		// java.sql.Date reg_date = new java.sql.Date(parsed.getTime());
		// Timestamp로 변환
		 Timestamp reg_date = new Timestamp(parsed.getTime());
		
		//--------------------------------------------------------------------------------
		// Timestamp ( or Date ) -> Format String 변환
		// Timestamp -> Format String
		// SimpleDateFormat sdf2 = new SimpleDateFormat("yy/MM/dd");
		// Timestamp reg_date = /*DB에서 꺼낸 값*/;
		// sdf.format(reg_date);
		
	}
}
