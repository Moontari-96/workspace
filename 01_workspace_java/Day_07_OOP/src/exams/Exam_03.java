package exams;

import classes.Tv;

public class Exam_03 {
	public static void main(String[] args) {

		Tv lg = new Tv(1000000, 10, 5);
		// lg.setPrice(1000);
		// lg.setChannel(16);
		// lg.setVolume(20);
		// Heap 메모리에는 초기값 0, Stack은 초기값 쓰레기값이 들어있음.
		System.out.println(lg.getPrice());
		System.out.println(lg.getChannel());
		System.out.println(lg.getVolume());
	}
}
