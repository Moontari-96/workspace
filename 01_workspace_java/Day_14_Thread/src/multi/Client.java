package multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
			System.out.println("서버에 연결할 수 없습니다.");
			System.out.println("같은 에러가 반복된다면 관리자에게 문의하세요.");
			System.out.println("관리자 : admin@naver.com");
			System.exit(0);
		}

		while (true) {
			try {
				int fl = dis.readInt();
				System.out.println(fl);
				String[] name = new String[fl];
				for (int i = 0; i < fl; i++) {
					name[i] = dis.readUTF();
					System.out.println(name[i]);
				}
				String targetName = sc.nextLine();
				dos.writeUTF(targetName);
				long targetFile = dis.readLong();
				byte[] targetFileName = new byte[(int) targetFile];
				dis.readFully(targetFileName);
				FileOutputStream fos = new FileOutputStream("C:/Users/타리/Desktop/MKY/workspace/tools/" + targetName);
				DataOutputStream fileDos = new DataOutputStream(fos);
				fileDos.write(targetFileName);
				fileDos.flush();
				fileDos.close();
				fos.close();
			} catch (Exception e) {
				System.exit(0);
			}
		}
	}
}
