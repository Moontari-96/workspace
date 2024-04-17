package multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class FileDownload extends Thread {
	private Socket client;

	public FileDownload(Socket client) {
		this.client = client;
	}

	public void run() {
		try {
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());

			File home = new File("C:/Users/타리/Desktop/MKY/workspace/libs/");
			File[] files = home.listFiles();

			dos.writeInt(files.length);
			dos.flush();

			for (File file : files) {
				dos.writeUTF(file.getName());
			}
			dos.flush();

			String targetFileName = dis.readUTF();
			System.out.println(client.getInetAddress() + " 의 요청 파일명 : " + targetFileName);

			String path = "C:/Users/타리/Desktop/MKY/workspace/libs/";
			// 다운받을 파일들의 경로
			File targetFile = new File(path + targetFileName);
//			byte[] targetFile = new byte[(int) targetFileName];

			FileInputStream fis = new FileInputStream(path + targetFileName);
			// HDD -> RAM으로 데이터를 받기 위한 스트림

			DataInputStream fileDis = new DataInputStream(fis);
			// Stream 업그레이드

			byte[] fileContents = new byte[(int) targetFile.length()];
			// HDD 파일의 내용을 전달받을 공간 확보

			fileDis.readFully(fileContents);
			// HDD 파일의 내용을 전부 byte[] 로 복사

			dos.writeLong(targetFile.length());
			dos.flush();
			// targetFile의 전송

			dos.write(fileContents);
			dos.flush();
			// targetFile 주소 값 전송

			fileDis.close();
			dis.close();
			dos.close();
		} catch (Exception e) {
			System.out.println(client.getInetAddress() + " 접속 해제 ");
		}

	}
}
