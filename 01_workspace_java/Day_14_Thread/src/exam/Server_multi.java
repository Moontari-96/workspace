package exam;

import java.net.ServerSocket;
import java.net.Socket;

public class Server_multi {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(30000);
		// 192.168.0.182
		while (true) {
			Socket socket = server.accept();

			FileThread ft = new FileThread(socket);
			ft.start();
		}
	}
}
