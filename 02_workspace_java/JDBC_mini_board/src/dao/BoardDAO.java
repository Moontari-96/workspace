package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import common.Statics;
import dto.BoardDTO;

public class BoardDAO {
	private Connection getConnection() throws Exception {
		return Statics.bds1.getConnection();
	}

	// 글 작성하는 메서드
	public int writeBoard(String contents) throws Exception {
		String sql = "insert into board values(board_seq.nextval,?,?,sysdate)";
		try (Connection con = this.getConnection(); 
			PreparedStatement pstat = con.prepareStatement(sql);) {
			pstat.setString(1, Statics.name);
			pstat.setString(2, contents);
			return pstat.executeUpdate();
		}
	}

	// 목록 출력 메서드
	public List<BoardDTO> listBoard() throws Exception {

		String sql = "select * from board";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			List<BoardDTO> list = new ArrayList<>();
			try (ResultSet rs = pstat.executeQuery();) {
				while (rs.next()) {
					int seq = rs.getInt(1);
					String writer = rs.getString(2);
					String content = rs.getString(3);
					Timestamp writer_date = rs.getTimestamp(4);
					BoardDTO dto = new BoardDTO(seq, writer, content, writer_date);
					list.add(dto);
				}
				return list;
			}
		}
	}

	// 글 조회 메서드
	public List<BoardDTO> SearchBoard(String target1, String target2) throws Exception {
		String sql = "select * from board where writer like ? and contents like ?";
		try (Connection con = this.getConnection(); PreparedStatement pstat = con.prepareStatement(sql);) {
			List<BoardDTO> list = new ArrayList<>();
			pstat.setString(1, "%" + target1 + "%");
			pstat.setString(2, "%" + target2 + "%");
			try (ResultSet rs = pstat.executeQuery();) {
				while (rs.next()) {
					int seq = rs.getInt(1);
					String writer = rs.getString(2);
					String content = rs.getString(3);
					Timestamp writer_date = rs.getTimestamp(4);
					BoardDTO dto = new BoardDTO(seq, writer, content, writer_date);
					list.add(dto);
				}
				return list;
			}
		}
	}

	// 수정 전 유효성 검사
	public boolean valdationBoard(int target) throws Exception {
		String sql = "select * from board where seq = ?";
		try (
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
			) {
			pstat.setInt(1, target);
			try (ResultSet rs = pstat.executeQuery();) 
			{
				return rs.next();
			}
		}
	}

	// 글 수정 메서드
	public int changeBoard(BoardDTO dto) throws Exception {
		String sql = "update board set writer = ?, contents = ?, writer_date = sysdate where seq = ?";
		try (Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);) 
		{
			pstat.setString(1, dto.getWirter());
			pstat.setString(2, dto.getContent());
			pstat.setInt(3, dto.getSeq());
			return pstat.executeUpdate();
		}
	}
	// 글 삭제 메서드
	public int deleteBoard(int target) throws Exception {
		String sql = "delete from board where seq = ?";
		try (Connection con = this.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);) 
		{
			pstat.setInt(1, target);
			return pstat.executeUpdate();
		}
	}
}
