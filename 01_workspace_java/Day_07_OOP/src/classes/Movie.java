package classes;

public class Movie {
	private String platform;
	// private String platform = "영화관"; // default value 인스턴스 생성 시 가장 먼저 생성 시킴
	// 초기화 시 가장 먼저 초기화 됨, default value는 설계자가 넣어두는 값
	// 생성자와 세터는 사용자가 넣는값
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

	public Movie() {
	}

	// 단 하나의 생성자 생성 시 디폴트 생성자는 지워짐
	public Movie(String platform, String title, String genre) {
		this.platform = platform;
		this.title = title;
		this.genre = genre;
	}

}
