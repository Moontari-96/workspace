package exam_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				Socket client = new Socket("192.168.0.161", 30000);
				DataInputStream dis = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				String msg = sc.nextLine();
				dos.writeUTF(msg);
			} catch (Exception e) {
				System.out.println("서버에 연결할 수 없습니다.");
				System.out.println("같은 에러가 반복된다면 관리자에게 문의하세요.");
				System.out.println("관리자 : admin@naver.com");
				System.exit(0);
			}
		}

	}
}
