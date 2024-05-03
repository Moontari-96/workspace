package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.Statics;
import dto.ServerDTO;


public class ServerDAO {
	private Connection getConnection() throws Exception {
		return Statics.bds.getConnection();
	}
	
	public int addMembers(ServerDTO dto) throws Exception {
		String sql = "insert into members values(?,?,?)";
		try(
			Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			){
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	
	
	public boolean validMembers(ServerDTO dto) throws Exception {
//		String sql = "select * from members where id = '" + dto.getId() + "' and pw = '" + dto.getPw() + "'";
		String sql = "select * from members where id = ? and pw = ?";
		System.out.println(sql);
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
			
				) {
				pstat.setString(1, dto.getId());
				pstat.setString(2, dto.getPw());
			try (
					ResultSet rs = pstat.executeQuery();
					)
			{
				
				boolean result = rs.next();
				return result;
			}
		}
		
	}	
}


