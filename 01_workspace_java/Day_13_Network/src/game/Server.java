package game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ServerSocket server = new ServerSocket(25000);
		Socket sock = server.accept();
		System.out.println(sock.getInetAddress() + " 로 부터 접속");

		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		while (true) {
			try {
				int menu = dis.read();
				if (menu == 1) {
					System.out.println("<< Game Start >>");
					int target = (int) (Math.random() * 10 + 1);
					dos.writeInt(target);
					dos.flush();
					System.out.println(target);
					while (true) {
						System.out.print("Input Number : ");
						int serverPl = Integer.parseInt(sc.nextLine()); // 플레이어의 시도
						dos.writeInt(serverPl);
						System.out.println("");
						int clientPl = dis.readInt();
						System.out.println(clientPl);
						if (clientPl > target) {
							System.out.println("Down!!");
							dos.writeInt(serverPl);
							dos.writeUTF("Down!!");
							dos.flush();
						} else if (clientPl < target) {
							dos.writeInt(serverPl);
							System.out.println("Up!!");
							dos.writeUTF("UP!!");
							dos.flush();
						} else {
							System.out.println("<< 정 답 >>");
							dos.writeUTF("<< 정답 >>");
							dos.flush();
							// 게임이 끝나는 시점에 현재 기록을 1로 reset
							break;
						}
					}
				}
			} catch (Exception e) {
				System.exit(0);
			}
		}
	}

}
