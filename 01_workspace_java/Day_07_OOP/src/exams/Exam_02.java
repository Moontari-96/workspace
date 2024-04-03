package exams;
import java.awt.Robot;

// 오토마우스
public class Exam_02 {
	public static void main(String[] args) throws Exception {

		Robot robot = new Robot();
		robot.mouseMove(400, 400);
		for (int i = 0; i < 100; i++) {
			robot.mouseMove(400 + i, 400);
			robot.delay(50);
		}
	}
}
