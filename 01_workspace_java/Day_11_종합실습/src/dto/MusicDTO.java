package dto;

public class MusicDTO {
	private String id;
	private String title;
	private String singer;
	private String date;

	public MusicDTO() {

	}

	public MusicDTO(String id, String title, String singer, String date) {
		this.id = id;
		this.title = title;
		this.singer = singer;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

}
