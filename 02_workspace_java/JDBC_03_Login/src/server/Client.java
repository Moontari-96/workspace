package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import common.Statics;

public class Client {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Socket socket = new Socket("192.168.1.4", 20000);
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		while (true) {
			try {
				System.out.println("1.로그인");
				System.out.println("2.회원가입");
				String menu = sc.nextLine();
				dos.writeUTF(menu);
				dos.flush();
				if (menu.equals("1")) {
					System.out.println("ID : ");
					String id = sc.nextLine();
					dos.writeUTF(id);
					System.out.println("PW : ");
					String pw = sc.nextLine();
					dos.writeUTF(pw);
					dos.flush();
					boolean result = dis.readBoolean();
					if (!result) {
						System.out.println("로그인 실패");
					} else {
						System.out.println("로그인 성공");
					}
				} else {
					System.out.println("ID : ");
					String id = sc.nextLine();
					dos.writeUTF(id);
					System.out.println("PW : ");
					String pw = sc.nextLine();
					dos.writeUTF(pw);
					System.out.println("Name : ");
					String name = sc.nextLine();
					dos.writeUTF(name);
					dos.flush();
					int result = dis.readInt();
					if (result > 0) {
						System.out.println("회원가입 성공");
					} else {
						System.out.println("회원가입 실패");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
