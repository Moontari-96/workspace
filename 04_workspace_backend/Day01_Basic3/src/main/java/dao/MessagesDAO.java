package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MessagesDTO;

public class MessagesDAO {
	// JNDI - Tomcat 서버에게 DBCP 인스턴스를 생성해 줄 것을 요구.
	// Singleton 기법 프로토타입
	// synchronized Thread Safe는 비용( COST )을 발생 => 성능 저하
	private static MessagesDAO instance;
	
	public synchronized static MessagesDAO getInstance() {
		if (instance == null) {
			instance = new MessagesDAO();
		}
		return instance;
	}
	
	// context 환경정보
	
	private Connection getconnection() throws Exception {
		Context ctx = new InitialContext(); 
		DataSource ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	private MessagesDAO(){}
	
//	private BasicDataSource bds;
//	private MessagesDAO(){
//		this.bds = new BasicDataSource();
//		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		bds.setUsername("servlet");
//		bds.setPassword("servlet");
//		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		bds.setInitialSize(3);
//	}

//	private Connection getconnection() throws Exception {
//		return bds.getConnection();
//	}
	
//	private Connection getconnection() throws Exception {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
//		String dbID = "servlet";
//		String dbPW = "servlet";
//		return DriverManager.getConnection(dbURL, dbID, dbPW);
//	}
	
	public int insert(MessagesDTO dto) throws Exception {
		String sql = "insert into messages values(messages_seq.nextval, ?, ?, sysdate)";
		try(
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			int result = pstat.executeUpdate();
			return result;
		}
	}
	public List<MessagesDTO> selectAll() throws Exception {
		String sql = "select * from messages";
		List<MessagesDTO> list = new ArrayList<>();
		try(Connection con = this.getconnection();
			PreparedStatement pstat = con.prepareStatement(sql);
				) {
			try (	
					ResultSet rs= pstat.executeQuery();
					){
				while(rs.next()) {
					int id = rs.getInt("id");
					String writer = rs.getString("writer");
					String message = rs.getString("message");
					Timestamp write_date = rs.getTimestamp("write_date");
					MessagesDTO dto = new MessagesDTO(id, writer, message, write_date);
					list.add(dto);
				}
				return list;
			}
		} 
	}
	public int deleteMessage(int target) throws Exception {
		String sql = "delete from messages where id = ?";
		try(
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);
			) {
			pstat.setInt(1, target);
			int result = pstat.executeUpdate();
			return result;
		}
	}
	public int updateMessage(MessagesDTO dto) throws Exception {
		String sql = "update messages set writer = ?, message = ?, write_date = sysdate where id = ?";
		try(Connection con = this.getconnection();
			PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			pstat.setInt(3, dto.getId());
			int result = pstat.executeUpdate();
			return result;
		} 
	}
}
