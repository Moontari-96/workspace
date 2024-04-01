import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int com = (int) (Math.random() * 3 + 1);
			System.out.println("=== 가위 바위 보 게임 ===");
			System.out.print("숫자를 선택하세요 (1.가위 / 2.바위 / 3.보) : ");
			int player = Integer.parseInt(sc.nextLine());
			System.out.println("=== 결과 ===");
			if (player == com) {
				if (1 == com) {
					System.out.println("당신은 " + "가위를 냈습니다.");
					System.out.println("컴퓨터는 " + "가위를 냈습니다.");
					System.out.println("==============");
					System.out.println("비겼습니다!");
				} else if (2 == com) {
					System.out.println("당신은 " + "바위를 냈습니다.");
					System.out.println("컴퓨터는 " + "바위를 냈습니다.");
					System.out.println("==============");
					System.out.println("비겼습니다!");
				} else {
					System.out.println("당신은 " + "보를 냈습니다.");
					System.out.println("컴퓨터는 " + "보를 냈습니다.");
					System.out.println("==============");
					System.out.println("비겼습니다!");
				}

			} else if (!(player == com) && player == 1) {
				if (com == 3) {
					System.out.println("당신은 " + "가위를 냈습니다.");
					System.out.println("컴퓨터는 " + "보를 냈습니다.");
					System.out.println("==============");
					System.out.println("플레이어가 이겼습니다!!");
				} else {
					System.out.println("당신은 " + "가위를 냈습니다.");
					System.out.println("컴퓨터는 " + "바위를 냈습니다.");
					System.out.println("==============");
					System.out.println("플레이어가 졌습니다!!");
				}
			} else if (!(player == com) && player == 2) {
				if (com == 1) {
					System.out.println("당신은 " + "바위를 냈습니다.");
					System.out.println("컴퓨터는 " + "가위를 냈습니다.");
					System.out.println("==============");
					System.out.println("플레이어가 이겼습니다!!");
				} else {
					System.out.println("당신은 " + "바위를 냈습니다.");
					System.out.println("컴퓨터는 " + "보를 냈습니다.");
					System.out.println("==============");
					System.out.println("플레이어가 졌습니다!!");
				}
			} else if (!(player == com) && player == 3) {
				if (com == 2) {
					System.out.println("당신은 " + "보를 냈습니다.");
					System.out.println("컴퓨터는 " + "바위를 냈습니다.");
					System.out.println("==============");
					System.out.println("플레이어가 이겼습니다!!");
				} else {
					System.out.println("당신은 " + "보를 냈습니다.");
					System.out.println("컴퓨터는 " + "가위를 냈습니다.");
					System.out.println("==============");
					System.out.println("플레이어가 졌습니다!!");
				}
			} else {
				System.out.println("선택지를 제대로 입력하십시오!");
			}
			System.out.println("");
		}
	}
}
