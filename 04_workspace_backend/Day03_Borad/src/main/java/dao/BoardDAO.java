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

import dto.BoardDTO;

public class BoardDAO {
private static BoardDAO instance;
	
	public synchronized static BoardDAO getInstance(){
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	private Connection getconnection() throws Exception {
		Context ctx = new InitialContext(); 
		DataSource ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	private BoardDAO(){};
	
	public List<BoardDTO> selectAll() throws Exception {
		String sql = "select * from board";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			List<BoardDTO> list = new ArrayList<>();
			try (	
					ResultSet rs= pstat.executeQuery();
					){
				 while(rs.next()) {
					 int seq = rs.getInt("seq");
					 String writer = rs.getString("writer");
					 String title = rs.getString("title");
					 String contents = rs.getString("contents");
					 Timestamp write_date = rs.getTimestamp("write_date");
					 int view_count = rs.getInt("view_count");
					 list.add(new BoardDTO(seq,writer,title,contents,write_date,view_count));
				 }
				 return list;
			}
		}
 	}
	
	public int insert(BoardDTO dto) throws Exception {
		String sql = "insert into board values(board_seq.nextval,?,?,?,sysdate,0)";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getTitle());
			pstat.setString(3, dto.getContents());
			int result = pstat.executeUpdate();
			return result;
		}	
				
	}
	
	public BoardDTO detailBoard(int seqNum) throws Exception {
		String sql = "select * from board where seq = ?";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			pstat.setInt(1, seqNum);
			try (	
					ResultSet rs= pstat.executeQuery();
					){
				 while(rs.next()) {
					 int seq = rs.getInt("seq");
					 String writer = rs.getString("writer");
					 String title = rs.getString("title");
					 String contents = rs.getString("contents");
					 Timestamp write_date = rs.getTimestamp("write_date");
					 int view_count = rs.getInt("view_count");
					 return new BoardDTO(seq,writer,title,contents,write_date,view_count);
				 }
			}
		}
		return null;
 	}
}	
