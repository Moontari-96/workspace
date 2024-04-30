package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Contact_DTO;

public class Contact_DAO {
	private String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbID = "contact";
	private String dbPW = "contact";
	
	private Connection getDB() throws Exception {
		return DriverManager.getConnection(dbURL, dbID, dbPW);
	}
	
	public int addContact(Contact_DTO dto) throws Exception {
		String sql = "insert into contact values(contact_seq.nextval, '"+dto.getName()+"', '" + dto.getPhone() + "')";
		try(
			Connection con = this.getDB();
			Statement stat = con.createStatement();
				){
			int result = stat.executeUpdate(sql);
			return result;
		}
	}
	
	public List<Contact_DTO> checkContact() throws Exception {
		String sql = "select * from contact";
		List<Contact_DTO> list = new ArrayList();
		try(
			Connection con = this.getDB();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			){
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				Contact_DTO dto = new Contact_DTO(id, name, phone);
				list.add(dto);
			}
			return list;
		}
	}
	
	public int deleteContact(int target) throws Exception {
		String sql = "delete from contact where id = " + target;
		try(
			Connection con = this.getDB();
			Statement stat = con.createStatement();
				){
			int result = stat.executeUpdate(sql);
			return result;
		}
	}
	
	public boolean valdationContact(int target) throws Exception {
		String sql = "select * from contact where id = " + target;
		try(
			Connection con = this.getDB();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			){
			return rs.next();
		}
	}
	
	public int changeContact(Contact_DTO dto) throws Exception {
		String sql = "update contact set name ='" + dto.getName() + "', phone ='" + dto.getPhone() + "' where id = " + dto.getId();
		try(
			Connection con = this.getDB();
			Statement stat = con.createStatement();
			){
			int result = stat.executeUpdate(sql);
			return result;
		}
	}
	
	public List<Contact_DTO> searchContact(String target) throws Exception {
		String sql = "select * from contact where name like '%" + target + "%'";
		List<Contact_DTO> list = new ArrayList();
		try(
			Connection con = this.getDB();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			){
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				Contact_DTO dto = new Contact_DTO(id, name, phone);
				list.add(dto);
			}
			return list;
		}
	}
}
