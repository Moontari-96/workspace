package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import commons.Statics;
import dto.ContactDTO;

public class ContactDAO {

//	private Connection getDB() throws Exception {
//		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
//		String dbID = "contact";
//		String dbPW = "contact";
//		return DriverManager.getConnection(dbURL, dbID, dbPW);
//	}
	
	// private static BasicDataSource bds = new BasicDataSource(); // 공통모듈로 제외시키는 방법도 있고 다른방법도 있으나 나중에 적용, 우선 전역변수화 시켜서 사용
	
//	public ContactDAO() {
//		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		bds.setUsername("contact");
//		bds.setPassword("contact");
//		bds.setInitialSize(20);
//	}
//	
	private Connection getDB() throws Exception {
		return Statics.bds.getConnection();
	}
	

	public int addContact(ContactDTO dto) throws Exception {
		String sql = "insert into contact values(contact_seq.nextval, ?, ?, sysdate)";
		try (
				Connection con = this.getDB(); 
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPhone());
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public List<ContactDTO> selectContact() throws Exception {
		String sql = "select * from contact order by 1";
		try (Connection con = this.getDB();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();) {
			List<ContactDTO> list = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				Timestamp reg_date = rs.getTimestamp(4);
				ContactDTO dto = new ContactDTO(id, name, phone, reg_date);
				list.add(dto);
			}
			return list;
		}
	}

	public int deleteContact(int target) throws Exception {
		String sql = "delete from contact where id = ?";
		try (
				Connection con = this.getDB(); 
				PreparedStatement pstat = con.prepareStatement(sql);
				) 
		{
			pstat.setInt(1, target);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public boolean valdationContact(int target) throws Exception {
		String sql = "select * from contact where id = ?";
		try (Connection con = this.getDB();
				PreparedStatement pstat = con.prepareStatement(sql);
		) 
		{
			pstat.setInt(0, target);
			try(
					ResultSet rs = pstat.executeQuery();
					) {
				return rs.next();
			}
		}
	}

	public int changeContact(ContactDTO dto) throws Exception {
		String sql = "update contact set name = ?, phone = ? where id = ?";
		try (
			Connection con = this.getDB();
			PreparedStatement pstat = con.prepareStatement(sql);
				) 
		{ 
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPhone());
			pstat.setInt(3, dto.getId());
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public List<ContactDTO> searchContact(String target) throws Exception {
		
		// PreparedStatement 사용 시 주의사항 2가지
		// 1. select 쿼리를 사용하는 ? 가 필요한 경우 try with resource를 2중으로 사용해야 함.
		// 2. like 구문을 사용하는 경우 pstat.set 위치에 %data%를 세팅해야 함.
		
		String sql = "select * from contact where name like ?";
		try (Connection con = this.getDB();
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			List<ContactDTO> list = new ArrayList<>();
			pstat.setString(1, "%" + target +"%");
			try (
					ResultSet rs = pstat.executeQuery();
					)
			{
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String phone = rs.getString(3);
					Timestamp reg_date = rs.getTimestamp(4);
					ContactDTO dto = new ContactDTO(id, name, phone, reg_date);
					list.add(dto);
				}
				return list;
			}
			
		}
	}
}
