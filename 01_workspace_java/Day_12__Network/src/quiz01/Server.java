package quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dao.NetworkDAO;

public class Server {
	public static void main(String[] args) throws Exception {

		NetworkDAO dao = new NetworkDAO();
		ServerSocket server = new ServerSocket(20000);
		Socket sock = server.accept();
		System.out.println(sock.getInetAddress() + " 로 부터 접속");

		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		while (true) {
			String choice = dis.readUTF();
			System.out.println(choice);
			if (choice.equals("1")) {

				// int[] arr = new int[45];
				//
				// for (int i = 0; i < arr.length; i++) {
				// arr[i] = i + 1;
				// }
				// for (int i = 0; i < 50000; i++) {
				// int x = (int) (Math.random() * 45);
				// int y = (int) (Math.random() * 45);
				// int tmp = arr[x];
				// arr[x] = arr[y];
				// arr[y] = tmp;
				//
				// }

				// dos.writeUTF(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " +
				// arr[4] + " " + arr[5]);
				// dos.writeUTF(JOptionPane.showInputDialog("보낼메시지",
				// arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " +
				// arr[5]));

				dos.writeUTF(dao.getLotto());
				dos.flush();

			} else if (choice.equals("2")) {
				// long ctime = System.currentTimeMillis();
				// SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
				// String time = sdf.format(ctime);

				dos.writeUTF(dao.getTime());
				dos.flush();
			}

			else if (choice.equals("3")) {
//				int menu = (int) (Math.random() * 3 + 1);
//				if (menu == 1) {
//					String one = "삶의 있는 한 희망은 있다";
//					dos.writeUTF(one);
//				} else if (menu == 2) {
//					String two = "산다는 것 그것은 치열한 전투이다.";
//					dos.writeUTF(two);
//				} else if (menu == 3) {
//					String three = "신은 용기있는 자를 결코 버리지 않는다.";
//					dos.writeUTF(three);
//				}
				dos.writeUTF(dao.getQuotes());
			} else {
				dos.writeUTF("");
				dos.flush();
			}
			// dos.writeUTF();

		}
	}

}
