package exam;

class Worker1 extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("@");
		}
	}
}

class Worker2 extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("$");
		}
	}
}

public class Exam_02 {
	public static void main(String[] args) {

		// #, @, $를 각 100번씩 멀티쓰레드로 화면에 출력해보세요.
		Worker1 worker1 = new Worker1();
		worker1.start();
		Worker2 worker2 = new Worker2();
		worker2.start();
		for (int i = 0; i < 100; i++) {
			System.out.print("#");
		}

	}
}
