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

import dto.MovieDTO;

public class MovieDAO {
	public static MovieDAO instance;
	public synchronized static MovieDAO getInstance(){
		if (instance == null) {
			instance = new MovieDAO();
		}
		return instance;
	}
	private Connection getconnection() throws Exception {
		Context ctx = new InitialContext(); 
		DataSource ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	private MovieDAO() {}
	
	public int insertMovie(MovieDTO dto) throws Exception {
		String sql = "insert into movies values(movies_seq.nextval,?,?,sysdate)";
		try(
			Connection con = this.getconnection();
			PreparedStatement pstat = con.prepareStatement(sql);
				)
		{
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			int result = pstat.executeUpdate();
			return result;
		}
		
	}
	public List<MovieDTO> selectAll() throws Exception {
		String sql = "select * from movies order by 1";
		try(
			Connection con = this.getconnection();
			PreparedStatement pstat = con.prepareStatement(sql);
				)
		{   List<MovieDTO> list = new ArrayList<>();  
			try(
					ResultSet rs = pstat.executeQuery();
					) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String genre = rs.getString("genre");
					Timestamp date = rs.getTimestamp("write_date");
					list.add(new MovieDTO(id,title,genre,date));
				}
				return list;
			}
		}
	}
	
	public int delMovie(int target) throws Exception {
		String sql = "delete from movies where id = ?";
		try(
			Connection con = this.getconnection();
			PreparedStatement pstat = con.prepareStatement(sql);
				) {
			pstat.setInt(1, target);
			int result = pstat.executeUpdate();
			return result;
		}
	}
	

	public int updateMovie(MovieDTO dto) throws Exception {
		String sql = "update movies set title = ?, genre = ?, write_date = sysdate where id = ?";
		try (
			Connection con = this.getconnection();
			PreparedStatement pstat = con.prepareStatement(sql);
				) 
		{ 
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			pstat.setInt(3, dto.getId());
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	
	
	
	
}
