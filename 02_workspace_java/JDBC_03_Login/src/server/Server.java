package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;

import dao.ServerDAO;
import dto.ServerDTO;

public class Server {
//	public static String getSHA512(String input){
//	    String toReturn = null;
//	    try {
//	        MessageDigest digest = MessageDigest.getInstance("SHA-512");
//	        digest.reset();
//	        digest.update(input.getBytes("utf8"));
//	        toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return toReturn;
//	  }
	public static void main(String[] args) {
		ServerDAO dao = new ServerDAO();
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
					String pw = dis.readUTF();
					ServerDTO dto = new ServerDTO(id, pw, null);
					System.out.println(dto.getId() + dto.getPw());
					boolean result = dao.validMembers(dto);
					System.out.println(result);
					dos.writeBoolean(result);
					dos.flush();
				} else if (menu.equals("2")) {
					String id = dis.readUTF();
					String pw = dis.readUTF();
					String name = dis.readUTF();
					ServerDTO dto = new ServerDTO(id, pw, name);
					int result = dao.addMembers(dto);
					System.out.println(result);
					dos.writeInt(result);
					dos.flush();
				}
			} 
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류가 발생했을 시 관리자에게 문의해주세요.");
		}
	}
}
