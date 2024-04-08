import java.io.File;

import it.sauronsoftware.ftp4j.FTPClient;

public class Exam_01 {
	public static void main(String[] args) {

		// FTP : File Transfer Protocol
		FTPClient client = new FTPClient();

		try {
			client.connect("192.168.0.161");
		} catch (Exception e) {
			e.printStackTrace(); // 에러 발생 사유 제공
			return;
		}

		try {
			client.login("java", "1234");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			client.download("abc.txt", new File("C:\\Users\\타리\\Desktop\\MKY\\workspace\\downloads\\download.txt"));
			// 다운로드할 파일 이름 / 다운받을위치 new File(경로)
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			client.disconnect(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
