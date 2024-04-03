package classes;

public class Movie {
	private String platform;
	private String title;
	private String genre;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
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

	public Movie(String platform, String title, String genre) {
		this.platform = platform;
		this.title = title;
		this.genre = genre;
	}

	public Movie() {
	}

}
