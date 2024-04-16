package exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(20000);
		Socket sock = server.accept();
		System.out.println(sock.getInetAddress() + " 로 부터 접속");

		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		while (true) {
			dos.writeUTF(JOptionPane.showInputDialog("보낼 메시지를 입력하세요 : "));
			dos.flush();
			String msg = dis.readUTF();
			System.out.println("Client : " + msg);
		}
	}
}
