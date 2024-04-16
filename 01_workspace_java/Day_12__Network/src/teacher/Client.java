package teacher;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Socket client = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			client = new Socket("127.0.0.1", 25000);
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("서버에 연결할 수 없습니다.");
			System.out.println("같은 에러가 반복된다면 관리자에게 문의하세요.");
			System.out.println("관리자 : admin@naver.com");
			System.exit(0);
		}

		while (true) {
			try {
				System.out.println("<< 서비스 예제 >>");
				System.out.println("1. 로또 번호 요청");
				System.out.println("2. 현재 시간 요청");
				System.out.println("3. 오늘의 명언");
				System.out.print(">> ");
				int menu = Integer.parseInt(sc.nextLine());

				dos.writeInt(menu);
				dos.flush();

				String result = dis.readUTF();

				if (menu == 1) {
					System.out.println("추천 로또 번호 : " + result);
				} else if (menu == 2) {
					System.out.println("현재 시간 : " + result);
				} else if (menu == 3) {
					System.out.println("오늘의 명언 : " + result);
				} else {
					System.out.println("메뉴를 다시 확인해주세요.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

	}
}
