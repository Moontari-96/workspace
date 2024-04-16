package dto;

public class MovieDTO {
	private String id;
	private String title;
	private String genre;
	private String write_date;

	public MovieDTO() {
	}

	public MovieDTO(String id, String title, String genre, String write_date) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.write_date = write_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String toString() {
		return id + " " + title + " " + genre + " " + write_date;
	}

}
