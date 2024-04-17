package exam;

import javax.swing.JOptionPane;

class CountDown extends Thread {

	public static int i = 10;

	public void run() {
		for (i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		System.out.println("Game Over!!");
		System.exit(0);
	}
}

public class Exam_03 {
	public static void main(String[] args) {
		new CountDown().start();
		while (true) {
			String[] setences = new String[] { "public static void main", "Scanner sc = new Scanner",
					"DataInputStrea dis = new DataInputStream" };
			int rand = (int) (Math.random() * 3);
			String msg = JOptionPane.showInputDialog(setences[rand]);
			if (msg.equals(setences[rand])) {
				System.out.println("성공!! +5");
				CountDown.i += 5;
			} else {
				System.out.println("오타!! -2");
				CountDown.i -= 2;
			}
		}

	}
}
