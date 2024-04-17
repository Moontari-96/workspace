package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

class Chat extends Thread {
	private DataOutputStream dos;

	public Chat(DataOutputStream dos) {
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

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(30000);
		Socket sock = server.accept();
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		Chat ch = new Chat(dos);
		ch.start();

		System.out.println(sock.getInetAddress() + " 로 부터 접속");
		while (true) {
			String msg = dis.readUTF();
			System.out.println(msg);
		}
	}
}
