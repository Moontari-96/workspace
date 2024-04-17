package exam;

class Worker extends Thread {
	// Step1
	// Thread 추상 메서드 없음
	// Thread 클래스 Default Constructor 있음

	public void run() {
		// Step2
		for (int i = 0; i < 100; i++) {
			System.out.print(i + " ");
		} // Step3

	}

}

public class Exam_01 {
	public static void main(String[] args) {

		// Thread - Process 내에서 작업을 처리하는 단위 ( 일꾼 )
		// Single Thread process : 하나의 Thread로 동작하는 프로그램
		// Multi Thread process : 하나 이상의 Thread로 동작하는 프로그램

		// Thread 사용법 Steps
		// Step1. Thread 클래스를 상속받는 사용자 정의 클래스를 작성한다.
		// Step2. Thread 클래스로 부터 상속받은 public void run 메서드를 override 한다.
		// Step3. Override된 메서드 내에 병행처리 할 코드를 작성한다.
		// Step4. 사용자 정의 클래스로부터 인스턴스를 생성한다.
		// Step5. 생성된 인스턴스로부터 start 메서드를 한다.

		Worker worker = new Worker(); // Step4
		worker.start(); // Step5

		for (int i = 0; i < 100; i++) {
			System.out.print(i + " ");
		}

	}
}
