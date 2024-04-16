package Netflix;

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
			client = new Socket("192.168.0.182", 25000);
			dis = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());

		} catch (Exception e) {
			System.exit(0);

		}

		while (true) {
			try {
				int index = 0;
				System.out.println("<< Netflix 영화 관리 시스템 >>");
				System.out.println("1. 신규 영화 등록 ");
				System.out.println("2. 영화 목록 출력 ");
				System.out.println("3. 영화 검색 (제목으로 검색)");
				System.out.println("4. 영화 삭제 (ID로 삭제)");
				System.out.println("5. 영화 정보 변경 (ID로 변경)");
				System.out.println(">>>");
				int menu = Integer.parseInt(sc.nextLine());

				dos.writeInt(menu);
				dos.flush();

				if (menu == 1) {

					System.out.println("등록할 영화 id :");
					String id = sc.nextLine();
					dos.writeUTF(id);
					System.out.println("등록할 영화 제목 :");
					String title = sc.nextLine();
					dos.writeUTF(title);
					System.out.println("등록할 영화 장르 : ");
					String genre = sc.nextLine();
					dos.writeUTF(genre);
					System.out.println("등록할 영화 출시일 : ");
					String date = sc.nextLine();
					dos.writeUTF(date);

					dos.writeUTF(date);
					index++;
				} else if (menu == 2) {
//				String [] movies = new String[] {dis.readUTF()};
//					String [] movie = new String[];
					int count = dis.readInt();
//					for (int i = 0; i < count; i++) {
//						String movie = dis.readUTF();
//						System.out.println(movie);
//					} 

					for (int i = 0; i < count; i++) {
						String id = dis.readUTF();
						String title = dis.readUTF();
						String genre = dis.readUTF();
						String date = dis.readUTF();
						System.out.println(id + "\t" + title + "\t" + genre + "\t" + date);
					}

				} else if (menu == 3) {
					System.out.println("검색할 영화의 제목 : ");
					String title = sc.nextLine();
					dos.writeUTF(title);

					int count = dis.readInt();
					for (int i = 0; i < count; i++) {

						String id = dis.readUTF();
						title = dis.readUTF();
						String genre = dis.readUTF();
						String date = dis.readUTF();
						System.out.println(id + "\t" + title + "\t" + genre + "\t" + date);
//							String movie = dis.readUTF();
//							System.out.println(movie);
					}

				} else if (menu == 4) {
					System.out.println("삭제할 영화의 ID 입력 : ");
					String id = sc.nextLine();
					dos.writeUTF(id);

					boolean bol = dis.readBoolean();
					System.out.println(bol);
					if (!bol) {
						System.out.println("id를 다시 입력해주세요.");

					} else {
						System.out.println("영화가 삭제 되었습니다.");
					}

				} else if (menu == 5) {
					System.out.println("수정할 영화의 ID 검색 :  ");
					String id = sc.nextLine();
					dos.writeUTF(id);
					System.out.println("수정할 영화의 제목 입력 :");
					String title = sc.nextLine();
					dos.writeUTF(title);
					System.out.println("수정할 영화 장르 입력 : ");
					String genre = sc.nextLine();
					dos.writeUTF(genre);
					System.out.println("수정할 영화 출시일 입력 : ");
					String date = sc.nextLine();
					dos.writeUTF(date);

					boolean bol = dis.readBoolean();
					System.out.println(bol);
					if (!bol) {
						System.out.println("id를 다시 입력해주세요.");

					} else {
						System.out.println("영화가 수정 되었습니다.");
					}
				}

				else {
					System.out.println("메뉴를 다시 확인해주세요.");
				}
			} catch (Exception e) {
				System.exit(0);
			}
		}
	}
}
