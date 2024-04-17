package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

class WriteThread extends Thread {
	private DataOutputStream dos;

	public WriteThread(DataOutputStream dos) {
		this.dos = dos;
	}

	public void run() {
		while (true) {
			try {
				dos.writeUTF(JOptionPane.showInputDialog("보낼 메시지를 확인하세요."));
				dos.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

public class Client {
	public static void main(String[] args) throws Exception {
		Socket sock = new Socket("127.0.0.1", 30000);
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		WriteThread chat = new WriteThread(dos);
		chat.start();

		System.out.println(sock.getInetAddress() + " 로 부터 접속");
		while (true) {
			String msg = dis.readUTF();
			System.out.println(msg);
		}
	}

}
