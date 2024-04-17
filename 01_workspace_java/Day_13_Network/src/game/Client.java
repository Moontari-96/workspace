package game;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Socket client = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			client = new Socket("127.0.0.1", 25000);
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
		} catch (Exception e) {
			System.exit(0);
		}
		while (true) {
			try {
				System.out.println("== UP & Down Game ==");
				System.out.println("1. Game Start");
				System.out.println("2. Game score");
				System.out.println("3. End Game");
				System.out.print(">> ");
				int menu = Integer.parseInt(sc.nextLine());
				dos.writeInt(menu);
				dos.flush();
				if (menu == 1) {
					int target = dis.readInt();
					System.out.println(target);
					while (true) {
						System.out.print("Input Number : ");
						int clientPl = Integer.parseInt(sc.nextLine()); // 플레이어의 시도
						dos.writeInt(clientPl);
						System.out.println("clientPl");
						System.out.println("");
						int serverPl = dis.readInt();
						System.out.println(serverPl);
						if (serverPl > target) {
							System.out.println("Down!!");
							dos.writeInt(clientPl);
							dos.writeUTF("Down!!");
							dos.flush();
						} else if (serverPl < target) {
							dos.writeInt(clientPl);
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
