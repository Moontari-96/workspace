package quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Socket client = new Socket("192.168.0.3", 20000); // 127.0.0.1 루프백 ip 자기 자신
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		while (true) {
			System.out.println("1.로또 번호 추천");
			System.out.println("2.현재 시간 요청");
			System.out.println("3.오늘의 명언");
			System.out.print(">>");
			dos.writeUTF(JOptionPane.showInputDialog("보낼메시지를 입력하세요."));
			dos.flush();
			String reply = dis.readUTF();
			System.out.println(reply);
			if (reply.equals("")) {
//				System.out.println("입력값확인해주세요.");
				dos.writeUTF(JOptionPane.showInputDialog("입력값을 확인해주세요."));
			}
		}
	}
}
