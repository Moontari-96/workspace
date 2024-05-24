package dto;

import java.sql.Timestamp;

public class MessagesDTO {
	public int id;
	public String writer;
	public String message;
	public Timestamp write_date;
	public MessagesDTO(int id, String writer, String message, Timestamp write_date) {
		super();
		this.id = id;
		this.writer = writer;
		this.message = message;
		this.write_date = write_date;
	}
	public MessagesDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
}
