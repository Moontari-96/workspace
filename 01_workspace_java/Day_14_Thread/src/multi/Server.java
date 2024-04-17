package multi;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(25000);
		while (true) {
			Socket socket = server.accept();
			FileDownload ft = new FileDownload(socket);
			ft.start();
		}
	}
}
