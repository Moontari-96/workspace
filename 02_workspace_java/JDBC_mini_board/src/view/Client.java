package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import dao.BoardDAO;
import dto.BoardDTO;

public class Client  {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Socket sock = new Socket("192.168.1.4", 20000);
		DataInputStream dis = new DataInputStream(sock.getInputStream());
		DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
		while (true) {
			System.out.println("<< Mini Borard 인증 >>");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 시스템 종료");
			System.out.print(">> ");
			String menu = sc.nextLine(); 
			dos.writeUTF(menu);
			dos.flush();
			try {
				if (menu.equals("1")) {
					System.out.println("<< 로그인 시 ID와 PW를 입력해 주세요! >>");
					System.out.print("ID : ");
					String id =  sc.nextLine();
					System.out.print("PW : ");
					String pw =  sc.nextLine();
					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.flush();
					boolean result = dis.readBoolean();
					if(result) {
						System.out.println("로그인 성공");
						System.out.println("");
						while (true) {
							System.out.println("<< Mini Borard 인증 >>");
							System.out.println("1. 글 작성하기");
							System.out.println("2. 글 목록보기");
							System.out.println("3. 글 검색하기");
							System.out.println("4. 글 수정하기");
							System.out.println("5. 글 삭제하기");
							System.out.println("0. 시스템 종료");
							System.out.print(">> ");
							menu = sc.nextLine();
							if (menu.equals("1")) {
								System.out.println("글을 입력하세요");
								System.out.print(">>");
								String contents = sc.nextLine();
								dos.writeUTF(contents);
								dos.flush();
							} else if (menu.equals("2")) {
								System.out.println("글 번호\t작성자\t글 내용\t작성날짜");
								int size = dis.readInt();
								for (int i = 0; i < size; i++) {
									System.out.println(dis.readInt() + "\t" + dis.readUTF()+ "\t" + dis.readUTF()+ "\t" + dis.readUTF());
								}
							} else if (menu.equals("3")) {
								System.out.print("찾고자하는 작성자 이름을 쓰세요 : ");
								String target1 = sc.nextLine();
								dos.writeUTF(target1);
								System.out.print("찾고자하는 글 내용을 쓰세요 : ");
								String target2 = sc.nextLine();
								dos.writeUTF(target2);
								System.out.println("글 번호\t작성자\t글 내용\t작성날짜");
								int size = dis.readInt();
								if (size != 0) {
									for (int i = 0; i < size; i++) {
										System.out.println(dis.readInt() + "\t" + dis.readUTF()+ "\t" + dis.readUTF()+ "\t" + dis.readUTF());
									}
									System.out.println("");
								} else {
									System.out.println("찾으려는 값이 없습니다.");
									System.out.println("");
								}
							} else if (menu.equals("4")) {
								System.out.print("수정하고자하는 글 번호를 입력하세요 : ");
								int seq = Integer.parseInt(sc.nextLine());
								dos.writeInt(seq);
								dos.flush();
								boolean valdation = dis.readBoolean();
								if(valdation) {
									System.out.print("수정하고자하는 이름 : ");
									String name = sc.nextLine();
									dos.writeUTF(name);
									System.out.print("수정하고자하는 내용 : ");
									String contents = sc.nextLine();
									dos.writeUTF(contents);
									dos.flush();
									int modify = dis.readInt();
									if (modify > 0) {
										System.out.println("수정이 완료되었습니다.");
										System.out.println("");
									}
								} else {
									System.out.println("수정할 대상이 없습니다.");
									System.out.println("");
								}
							} else if (menu.equals("5")) {
								System.out.println("삭제할 글 번호를 입력하세요.");
								int seq = Integer.parseInt(sc.nextLine());
								dos.writeInt(seq);
								dos.flush();
								int result1 = dis.readInt();
								if (result1 > 0) {
									System.out.println("삭제가 완료되었습니다.");
									System.out.println("");
								} else {
									System.out.println("삭제할 대상이 없습니다 다시입력해주세요!");
									System.out.println("");
								}
							} else if (menu.equals("0")) {
								System.out.println("시스템을 종료합니다.");
								System.exit(0);
							} else {
								System.out.println("숫자만 입력해주세요.");
							}
						}
						
					} else {
						System.out.println("로그인 실패");
						System.out.println("");
					}
					
				} else if (menu.equals("2")) {
					System.out.println("<< 회원가입 시 사용하실 ID, PW, 이름을 입력해주세요! >>");
					System.out.print("ID : ");
					String id =  sc.nextLine();
					System.out.print("PW : ");
					String pw =  sc.nextLine();
					System.out.print("이름 : ");
					String name =  sc.nextLine();
					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.writeUTF(name);
					dos.flush();
					int result = dis.readInt();
					if (result > 0) {
						System.out.println("회원가입에 성공하였습니다. 축하드립니다!!");
						System.out.println("");
					}
				} else if (menu.equals("0")) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				} 
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("오류가 발생하였습니다. 관리자에게 문의 바랍니다! shaaa6256@naver.com");
			}
		}
	}
}
