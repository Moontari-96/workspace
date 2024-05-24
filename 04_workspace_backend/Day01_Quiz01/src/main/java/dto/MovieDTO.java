package dto;

import java.sql.Timestamp;

public class MovieDTO {
	public int id;
	public String title;
	public String genre;
	public Timestamp write_date;
	public MovieDTO(int id, String title, String genre, Timestamp write_date) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.write_date = write_date;
	}
	public MovieDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
	
}
