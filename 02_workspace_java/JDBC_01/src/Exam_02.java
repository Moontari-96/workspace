import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam_02 {
	public static void main(String[] args) throws Exception{
		// Cafe Mocha 메뉴의 가격을 3500원으로 인하하는 코드를 작성해주세요.
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kedu";
		String dbPW = "kedu";
		
		Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
		Statement stat = con.createStatement();
		
		String sql = "update cafe set price = 2500 where id = 1002";
		int result = stat.executeUpdate(sql);
		
		if(result > 0) {
			System.out.println(result +"개 입력성공!");
		}
		
		con.close();
	}
}
