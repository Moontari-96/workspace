package exam;

import java.io.DataInputStream;
import java.net.Socket;

public class FileThread extends Thread {

	private Socket client;

	public FileThread(Socket client) {
		this.client = client;
	}

	public void run() {
		try {
			DataInputStream dis = new DataInputStream(client.getInputStream());
			while (true) {
				String msg = dis.readUTF();
				System.out.println(msg);
			}
		} catch (Exception e) {
			System.out.println(client.getInetAddress() + " 접속 해제");
		}

	}

}
