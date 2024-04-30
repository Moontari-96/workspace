package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.CafeDTO;

public class CafeDAO {
	ArrayList<CafeDTO> menus = new ArrayList<>();
	private String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbID = "kedu";
	private String dbPW = "kedu";
	
	// Wrapper Method
	private Connection getConnection() throws Exception {
		return DriverManager.getConnection(dbURL, dbID, dbPW);
	}
	
	//	try ~ catch
	//	try ~ finally
	//	try ~ with ~ resource
	public void inDB(CafeDTO dto) throws Exception {
		// throws Exception 전가 코드의 이해 : 예외 전가를 적용한 callee method가 caller method에게 전가함	
		try(
			Connection con = this.getConnection();
			Statement stat = con.createStatement();
				){
			String sql = "insert into cafe values(cafe_seq.nextval,'"+ dto.getName() + "', "+ dto.getPrice() + ")";
			stat.executeUpdate(sql);
			// con.close(); => try ~ with ~ resource : ()안의 내용은 모두 close처리 catch, finally를 붙여서 사용가능
		}		
	}
	
	public int delDB(int target) throws Exception {
		String sql = "delete from cafe where id = " + target;
		try(
			Connection con = this.getConnection();
			Statement stat = con.createStatement();	
				){
			int result = stat.executeUpdate(sql);
			return result;
		}
		
	}
	
	public boolean validationDB(int id) throws Exception {
		String sql = "select * from cafe where id = " + id;

		try(
			Connection con = this.getConnection();
			Statement stat = con.createStatement();
				) {
			ResultSet rs = stat.executeQuery(sql);
			boolean result = rs.next();
			return result;
		}
		
		
	} 
	
	public int changeDB(CafeDTO dto) throws Exception {
		try (
			Connection con = this.getConnection();
			Statement stat = con.createStatement();	
				){
			String sql = "update cafe set name ='" + dto.getName() + "', price = " + dto.getPrice() + " where id = " + dto.getId();
			int result = stat.executeUpdate(sql);
			return result;	
		}
	}
	
	public List<CafeDTO> checkDB() throws Exception {
		List<CafeDTO> list = new ArrayList<>();
		String sql = "select * from cafe";
		try(
			Connection con = this.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
				) {
				while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				CafeDTO dto = new CafeDTO(id,name,price);
				list.add(dto);
			}
			return list;
		}
		
	}
	
	public List<CafeDTO> searchDB(String target) throws Exception {
		String sql = "select * from cafe where name like '%" + target +"%'";
		List<CafeDTO> list = new ArrayList<>();
		try(
			Connection con = this.getConnection();
			Statement stat = con.createStatement();	
			ResultSet rs = stat.executeQuery(sql);
				) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				CafeDTO dto = new CafeDTO(id,name,price);
				list.add(dto);	
			}
			return list;
		}
	}
	
	
}
