package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.List;

import dao.BoardDAO;
import dao.MembersDAO;
import dto.BoardDTO;
import dto.MembersDTO;

public class Server {
	public static String getSHA512(String input) {
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
		MembersDAO mdao = new MembersDAO();
		BoardDAO bdao = new BoardDAO();
		try {
			ServerSocket server = new ServerSocket(20000);
			Socket sock = server.accept();
			System.out.println(sock.getInetAddress() + " 로 부터 접속");
			OutputStream os = sock.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			InputStream is = sock.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			while (true) {
				String menu = dis.readUTF();
				if (menu.equals("1")) {
					String id = dis.readUTF();
					String pw = getSHA512(dis.readUTF());
					MembersDTO dto = new MembersDTO(id, pw, null, null);
					boolean result = mdao.loginMembers(dto);
					System.out.println(result);
					dos.writeBoolean(result);
					dos.flush();
					if (result) {
						while (true) {
							menu = dis.readUTF();
							if (menu.equals("1")) {
								String contents = dis.readUTF();
								bdao.writeBoard(contents);
							} else if (menu.equals("2")) {
								List<BoardDTO> list = bdao.listBoard();
								dos.writeInt(list.size());
								for (BoardDTO dto1 : list) {
									dos.write(dto1.getSeq());
									dos.writeUTF(dto1.getWirter());
									dos.writeUTF(dto1.getContent());
									dos.writeUTF(dto1.getFormedDate());
								}
								dos.flush();
								System.out.println("");
							} else if (menu.equals("3")) {
								String target1 = dis.readUTF();
								String target2 = dis.readUTF();
								List<BoardDTO> list = bdao.SearchBoard(target1, target2);
								dos.writeInt(list.size());
								for (BoardDTO searchdto : list) {
									dos.write(searchdto.getSeq());
									dos.writeUTF(searchdto.getWirter());
									dos.writeUTF(searchdto.getContent());
									dos.writeUTF(searchdto.getFormedDate());
								}
								dos.flush();
							} else if (menu.equals("4")) {
								System.out.print("수정하고자하는 글 번호를 입력하세요 : ");
								int seq = dis.readInt();
								boolean valdation = bdao.valdationBoard(seq);
								dos.writeBoolean(valdation);
								dos.flush();
								if (valdation) {
									String name = dis.readUTF();
									String contents = dis.readUTF();
									int modify = bdao.changeBoard(new BoardDTO(seq, name, contents, null));
									dos.writeInt(modify);
								}
							} else if (menu.equals("5")) {
								int seq = dis.readInt();
								int result1 = bdao.deleteBoard(seq);
								dos.writeInt(result1);
								dos.flush();
							} else if (menu.equals("0")) {
								System.exit(0);
							} else {
							}
						}
					} else {
					}
				} else if (menu.equals("2")) {
					String id = dis.readUTF();
					String pw = getSHA512(dis.readUTF());
					String name = dis.readUTF();
					MembersDTO dto = new MembersDTO(id, pw, name, null);
					int result = mdao.joinMembers(dto);
					System.out.println(result);
					dos.writeInt(result);
					dos.flush();
				} else if (menu.equals("0")) {
					System.exit(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
