import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
// OJDBC 8 버전 이후 부터는 자동커밋
public class Exam_01 {
	public static void main(String[] args) throws Exception {
		// Main / DTO / DAO
		
		// 기존 코드는 ArrayList에 저장하고 있음
		// DAO 내의 addList 기능의 내용이 DBMS로 데이터를 저장하는 코드로 변경되어야 함.
		
		// * 실전 코드
		// DBMS ( localhost - 1521 ) 에 연결시도
		// OJDBC ( Oracle Java DateBase Connectivity ) 라이브러리
		// URL (jdbc:oracle:thin:@) 이부분은 고정 텍스트 -> 공식
		// @ 이후는 IP주소, Port번호, xe는 oracle 타입
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("메뉴 이름 : ");
		String name = sc.nextLine();
		System.out.print("메뉴 가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kedu";
		String dbPW = "kedu";
		
		// DBMS 접속
		Connection con = DriverManager.getConnection(dbURL, dbID, dbPW); // **접속 방법 외우기**
		// Query 전달을 위한 Statement 객체 확보 / Query 쓸 수 있는 편집기 객체 확보 
		Statement stat = con.createStatement(); 
		
		// stat.executeUpdate(); // Insert, Update, Delete / DB에 영향을 줄 때 / return 변화된 행의 갯수 
		// stat.executeQuery(); // Select / DB에 영향을 안줄 때 
		
		String sql = "insert into cafe values(cafe_seq.nextval,'"+ name + "', "+ price + ")";
		int result = stat.executeUpdate(sql);
		
		if (result > 0) {
			System.out.println("입력 성공!");
		}

		con.close();
		
	}
}
