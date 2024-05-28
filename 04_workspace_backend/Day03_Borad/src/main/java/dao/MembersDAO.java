package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MembersDTO;

public class MembersDAO {
	private static MembersDAO instance;
	
	public synchronized static MembersDAO getInstance(){
		if (instance == null) {
			instance = new MembersDAO();
		}
		return instance;
	}
	
	private Connection getconnection() throws Exception {
		Context ctx = new InitialContext(); 
		DataSource ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	private MembersDAO(){};
	
	public boolean checkID(String id) throws Exception {
		String sql = "select * from members where id = ?";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, id);
			try (	
					ResultSet rs= pstat.executeQuery();
					){
				return rs.next();
			}
		}			
	}
	public int joinMembers(MembersDTO dto) throws Exception {
		String sql = "insert into members (id, pw, name, phone, email, zipcode, address1, address2) values(?, ?, ?, ?, ?, ?, ?, ?)";
		try(
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getPhone());
			pstat.setString(5, dto.getEmail());
			pstat.setString(6, dto.getZipcode());
			pstat.setString(7, dto.getAddress1());
			pstat.setString(8, dto.getAddress2());
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	public boolean checkLogin(String id, String pw) throws Exception {
		String sql = "select * from members where id = ? and pw = ?";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, id);
			pstat.setString(2, pw);
			try (	
					ResultSet rs= pstat.executeQuery();
					){
				return rs.next();
			}
		}			
	}
	
	public int cancleMember(String id) throws Exception {
		String sql = "delete from members where id = ?";
		try(
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, id);
			int result = pstat.executeUpdate();
			return result;
		}
	}
	public MembersDTO inMypage(String id) throws Exception {
		String sql = "select * from members where id = ?";
		
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, id);
			try (	
					ResultSet rs= pstat.executeQuery();
					){
				 while(rs.next()) {
					 String userID = rs.getString("id");
					 String userName = rs.getString("name");
					 String userPhone = rs.getString("phone");
					 String userEmail = rs.getString("email");
					 String userZipcode = rs.getString("zipcode");
					 String userAddress1 = rs.getString("address1");
					 String userAddress2 = rs.getString("address2");
					 Timestamp userJoindate = rs.getTimestamp("join_date");
					 return new MembersDTO(userID,null,userName,userPhone,userEmail,userZipcode,userAddress1,userAddress2,userJoindate);
				 }
			}
		}
		 return null;
	}
	public int modifyUser(MembersDTO dto) throws Exception {
		String sql = "update members set name = ?, phone = ?, email = ?, zipcode = ?, address1 = ?, address2 = ? where id = ?";
		try(
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);
			) {
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPhone());
			pstat.setString(3, dto.getEmail());
			pstat.setString(4, dto.getZipcode());
			pstat.setString(5, dto.getAddress1());
			pstat.setString(6, dto.getAddress2());
			pstat.setString(7, dto.getId());
			int result = pstat.executeUpdate();
			return result;
		}
	}
}
