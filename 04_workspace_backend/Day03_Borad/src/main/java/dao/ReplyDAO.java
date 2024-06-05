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
import dto.ReplyDTO;

public class ReplyDAO {
	private static ReplyDAO instance;
	public synchronized static ReplyDAO getInstance(){
		if (instance == null) {
			instance = new ReplyDAO();
		}
		return instance;
	}
	
	private Connection getconnection() throws Exception {
		Context ctx = new InitialContext(); 
		DataSource ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	private ReplyDAO(){};
	
	public List<ReplyDTO> selectAll(int pseq) throws Exception {
		String sql = "select * from reply where parent_seq = ? order by 1 desc";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			List<ReplyDTO> list = new ArrayList<>();
			pstat.setInt(1, pseq);
			try (	
					ResultSet rs= pstat.executeQuery();
					){
				 while(rs.next()) {
					 int seq = rs.getInt("seq");
					 String writer = rs.getString("writer");
					 String contents = rs.getString("contents");
					 Timestamp write_date = rs.getTimestamp("write_date");
					 int parent_seq = rs.getInt("parent_seq");
					 list.add(new ReplyDTO(seq,writer,contents,write_date,parent_seq));
				 }
				 return list;
			}
		}
 	}
	 
	public int insertReply(ReplyDTO dto) throws Exception {
		String sql = "insert into reply values(reply_seq.nextval,?,?,sysdate,?)";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getContents());
			pstat.setInt(3, dto.getParent_seq());
			int result = pstat.executeUpdate();
			return result;
		}	
				
	}
	
	public int deleteReply(int replyseq) throws Exception {
		String sql = "delete from reply where seq = ?";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			pstat.setInt(1, replyseq);
			int result = pstat.executeUpdate();
			return result;
		}	
	}
	
	public int updateReply(ReplyDTO dto) throws Exception {
		String sql = "update reply set contents = ? where seq = ?";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			pstat.setString(1, dto.getContents());
			pstat.setInt(2, dto.getSeq());
			int result = pstat.executeUpdate();
			return result;
		}	
	}
}
