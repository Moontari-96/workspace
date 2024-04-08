import java.io.FileInputStream;

import javazoom.jl.player.Player; // 써드 파티 라이브러리, 외부 라이브러리

public class Exam_01 {
	public static void main(String[] args) {

		// Music Play 기능 만들기!
		try {
			FileInputStream fis = new FileInputStream("kasina.mp3");
			Player playMP3 = new Player(fis);
			playMP3.play();
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("Failed to play the file.");
		}
	}
}
