package view;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.List;
import java.util.Scanner;

import dao.BoardDAO;
import dao.MembersDAO;
import dto.BoardDTO;
import dto.MembersDTO;

public class Main {
	public static String getSHA512(String input){
	    String toReturn = null;
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-512");
	        digest.reset();
	        digest.update(input.getBytes("utf8"));
	        toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return toReturn;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MembersDAO mdao = new MembersDAO();
		BoardDAO bdao = new BoardDAO();
		
		while (true) {
			System.out.println("<< Mini Borard 인증 >>");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 시스템 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();
			try {
				if (menu.equals("1")) {
					System.out.println("<< 로그인 시 ID와 PW를 입력해 주세요! >>");
					System.out.print("ID : ");
					String id =  sc.nextLine();
					System.out.print("PW : ");
					String pw =  getSHA512(sc.nextLine());
					
					boolean result = mdao.loginMembers(new MembersDTO(id,pw,null,null));
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
								String writing = sc.nextLine();
								bdao.writeBoard(writing);
							} else if (menu.equals("2")) {
								System.out.println("글 번호\t작성자\t글 내용\t작성날짜");
								List<BoardDTO> list = bdao.listBoard();
								for (BoardDTO dto : list) {
									System.out.println(dto.getSeq() + "\t" + dto.getWirter() + "\t" +  dto.getContent() + "\t" + dto.getFormedDate());
								}
								System.out.println("");
							} else if (menu.equals("3")) {
								System.out.print("찾고자하는 작성자 이름을 쓰세요 : ");
								String target1 = sc.nextLine();
								System.out.print("찾고자하는 글 내용을 쓰세요 : ");
								String target2 = sc.nextLine();
								List<BoardDTO> list = bdao.SearchBoard(target1, target2);
								System.out.println("글 번호\t작성자\t글 내용\t작성날짜");
								if (list.size() != 0) {
									for (BoardDTO dto : list) {
										System.out.println(dto.getSeq() + "\t" + dto.getWirter() + "\t" +  dto.getContent() + "\t" + dto.getFormedDate());
									}
									System.out.println("");
								} else {
									System.out.println("찾으려는 값이 없습니다.");
									System.out.println("");
								}
							} else if (menu.equals("4")) {
								System.out.print("수정하고자하는 글 번호를 입력하세요 : ");
								int seq = Integer.parseInt(sc.nextLine());
								boolean valdation = bdao.valdationBoard(seq);
								System.out.println(valdation);
								if(valdation) {
									System.out.print("수정하고자하는 이름 : ");
									String name = sc.nextLine();
									System.out.print("수정하고자하는 내용 : ");
									String content = sc.nextLine();
									int modify = bdao.changeBoard(new BoardDTO(seq,name,content,null));
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
								int result1 = bdao.deleteBoard(seq);
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
					String pw =  getSHA512(sc.nextLine());
					System.out.print("이름 : ");
					String name =  sc.nextLine();
					
					int result = mdao.joinMembers(new MembersDTO(id, pw, name, null));
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
