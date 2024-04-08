package quizs;

import classes.Movie;

public class Quiz_03 {
	public static void main(String[] args) {

		Movie[] movies = new Movie[2]; // movie 주소 저장할 배열, 변수 2개 인스턴스 생성은 아님
		movies[0] = new Movie("Netflix", "범죄도시3", "액션/코미디"); // Movie 인스턴스 생성
		movies[1] = new Movie("메가박스", "파묘", "오컬트");
		System.out.println(movies[1].getTitle());

	}
}
