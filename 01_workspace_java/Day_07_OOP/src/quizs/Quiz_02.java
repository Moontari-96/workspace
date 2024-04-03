package quizs;

import classes.Movie;

public class Quiz_02 {
	public static void main(String[] args) {
		// 1. 플랫폼명 / 제목 / 장르를 멤버필드로 가지는 Movie 클래스를 생성

		// 2. Movie 클래스를 바탕으로 인스턴스를 생성하되,
		// 생성자 인자값으로
		// 플랫폼 : Netflix
		// 제목 : 범죄도시3
		// 장르 : 액션/코미디
		// 위 데이터를 전달하여 인스턴스를 생성

		// 3. 동일한 타입의 인스턴스를 하나 더 생성하되,
		// 초기값은 자유 설정
		// 단, 생성자가 아닌 setter로 초기화 해보기.

		// 4.생성된 두개 인스턴스의 내용 전부 출력해보기.

		// 영화 인스턴스
		Movie myMovie = new Movie("Netflix", "범죄도시3", "액션/코미디");
		System.out.println(myMovie.getPlatform());
		System.out.println(myMovie.getTitle());
		System.out.println(myMovie.getGenre());
		System.out.println("");

		// 드라마 인스턴스
		Movie myDrama = new Movie(); // 생성자 오버로딩을 통한 초기값 초기화
		myDrama.setPlatform("Tving");
		myDrama.setTitle("눈물의 여왕");
		myDrama.setGenre("로맨스/코메디");
		System.out.println(myDrama.getPlatform());
		System.out.println(myDrama.getTitle());
		System.out.println(myDrama.getGenre());
	}
}
