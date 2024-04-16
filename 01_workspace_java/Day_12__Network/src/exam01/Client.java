package exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws Exception {

		Socket client = new Socket("192.168.0.3", 26000);

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		while (true) {
			String msg = dis.readUTF();
			System.out.println("Server : " + msg);
			dos.writeUTF(JOptionPane.showInputDialog("보낼 메세지를 입력하세요."));
			dos.flush();
		}

	}
}
