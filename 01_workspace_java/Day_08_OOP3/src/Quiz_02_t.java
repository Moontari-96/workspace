import java.io.File;
import java.util.Random;

import it.sauronsoftware.ftp4j.FTPClient;

public class Quiz_02_t {
	public static void main(String[] args) throws Exception {
		FTPClient client = new FTPClient();
		client.setCharset("euckr");

//		client.connect("192.168.0.161");
//		char[] keys = "!@#$%^&*()".toCharArray();
		// 숫자 문자 프로모션
		// 1 + ""
		// String.valueOf()

//		# 사용할 특수 문자
//		while (true) {
//			String password = generateRandomPassword(4);
//			try {
//				client.login("java", password);
//				break;
//			} catch (Exception e) {
//				System.out.println("로그인 실패 : " + password);
//			}
//		}
//		for (int i = 1000; i < 9999; i++) {
//			client.login("java", i + "");
//		}

		client.download("top_secret.txt", new File("C:\\Users\\타리\\Desktop\\MKY\\workspace\\downloads\\성공.txt"));
		client.disconnect(true);
	}

	public static String generateRandomPassword(int length) {
		// 비밀번호로 사용할 문자열
		String characters = "!@#$%^&*()";

		// 무작위 숫자를 생성하는 랜덤 객체 생성
		Random random = new Random();

		// 무작위 비밀번호 생성
		StringBuilder passwordBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			// characters 문자열에서 무작위 인덱스를 선택하여 비밀번호에 추가
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			passwordBuilder.append(randomChar);
		}
		return passwordBuilder.toString();
	}
}
