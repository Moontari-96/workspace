package exam_01;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(40000);

		while (true) {
			Socket socket = server.accept();
			try {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				String msg = dis.readUTF();
				System.out.println(socket.getInetAddress() + "의 메시지 : " + msg);
			} catch (Exception e) {
				System.out.println(socket.getInetAddress() + " 접속해제 ");
			}
		}
	}
}
