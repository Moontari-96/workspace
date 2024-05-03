package dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BoardDTO {
	private int seq;
	private String wirter;
	private String content;
	private Timestamp writer_date;
	
	public BoardDTO(int seq, String wirter, String content, Timestamp writer_date) {
		super();
		this.seq = seq;
		this.wirter = wirter;
		this.content = content;
		this.writer_date = writer_date;
	}
	
	public BoardDTO() {
		super();
	}
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int id) {
		this.seq = seq;
	}
	
	public String getWirter() {
		return wirter;
	}
	
	public void setWirter(String wirter) {
		this.wirter = wirter;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getWriter_date() {
		return writer_date;
	}
	
	public void setWriter_date(Timestamp writer_date) {
		this.writer_date = writer_date;
	}
	
	public String getFormedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd");
		return sdf.format(this.writer_date.getTime());
	} 
	
	
}
