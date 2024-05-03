package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.Statics;
import dto.MembersDTO;

public class MembersDAO {
	
	private Connection getConnection() throws Exception {
		return Statics.bds1.getConnection();
	}
	
	// 회원가입 메서드
	public int joinMembers(MembersDTO dto) throws Exception {
		String sql = "insert into members values(?,?,?,sysdate)";
		try 
		(
			Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
				)
			{
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			return pstat.executeUpdate();
		}
	}
	// Login 검사 메서드
	public boolean loginMembers(MembersDTO dto) throws Exception  {
		String sql = "select * from members where id = ? and pw = ?";
		boolean result= false;
		try 
		(
			Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
				)
			{
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			try (
				ResultSet rs = pstat.executeQuery();
					) {
				result = rs.next();
				if (result) {
					Statics.name = rs.getString("name");
				}
				return result;
			}
		}
	}
}
