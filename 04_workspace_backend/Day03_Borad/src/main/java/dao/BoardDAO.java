package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import commons.BoardConfig;
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
		String sql = "select * from board order by 1 desc";
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
	
	public List<BoardDTO> selectNtoM(int startNum, int endNum) throws Exception {
		String sql = "select * from (select board.*, row_number() over(order by seq desc) rown from board) where rown between ? and ?";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			List<BoardDTO> list = new ArrayList<>();
			pstat.setInt(1, startNum);
			pstat.setInt(2, endNum);
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
	
	public int deleteBoard(int seq) throws Exception {
		String sql = "delete from board where seq = ?";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			pstat.setInt(1, seq);
			int result = pstat.executeUpdate();
			return result;
		}	
	}
	
	public int updateBoard(BoardDTO dto) throws Exception {
		String sql = "update board set title = ?, contents = ? where seq = ?";
		try (
				Connection con = this.getconnection();
				PreparedStatement pstat = con.prepareStatement(sql);	
				) {
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContents());
			pstat.setInt(3, dto.getSeq());
			int result = pstat.executeUpdate();
			return result;
		}	
	}
	
	public int updateViewCount(int seq) throws Exception{
		String sql = "update board set view_count = view_count + 1 where seq = ?";
		try (
						Connection con = this.getconnection();
						PreparedStatement pstat = con.prepareStatement(sql);	
						) {
					pstat.setInt(1, seq);
					return pstat.executeUpdate();
		}		
	}
	
	private int getRecordCount() throws Exception {
		String sql = "select count(*) from board";
		try (
						Connection con = this.getconnection();
						PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs= pstat.executeQuery();
						) {
				 rs.next();
				 return rs.getInt(1);
			}
	}
	
	public String getPageNavi(int currentPage) throws Exception{
		// 1. 전체 글의 개수 
		int recordTotalCount= this.getRecordCount(); // 향후 DB에서 알아와야 하는 값 
				
		// 2. 한 페이지에 몇개의 게시글을 보여줄 것인지 결정
		 int recordCountPerPage = BoardConfig.recordCountPerPage;
				
				
		// 3. Page Navigator 를 몇 개씩 보여줄 것 인지 결정
		int naviCountPerPage = BoardConfig.naviCountPerPage;
				

		int pageTotalCount = 0;
				
		if (recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
				
		// int currentPage = 2; // 향후 클라이언트가 누르는 번호로 대체 될 예정
				
		// 네비게이터의 시작 값
		int startNavi = ( currentPage - 1 ) / naviCountPerPage * naviCountPerPage + 1;
		// 네비게이터의 끝 값
		int endNavi = startNavi + naviCountPerPage - 1;
				
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
				
		boolean needNext = true;
		boolean needPrev = true;
				
		if(startNavi == 1) {
			needPrev = false;
		}
				
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
				
		StringBuilder sb = new StringBuilder();
		
		if(needPrev)
		{sb.append("<a href='/list.board?cpage=" + (startNavi-1) +"'>< </a>");}		
		for(int i = startNavi; i <= endNavi; i++) {
			if(currentPage == i) {
				sb.append("<a class='active' href='/list.board?cpage="+i+"'>" + i + "</a> ");
			} else {
				sb.append("<a href='/list.board?cpage="+i+"'>" + i + "</a> ");
			}
			
		}
		if(needNext) {
			sb.append("<a href='/list.board?cpage=" + (endNavi+1) +"'> ></a>");
		}
		return sb.toString();
	}
}	
