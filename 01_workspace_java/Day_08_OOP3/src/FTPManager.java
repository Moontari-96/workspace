import java.io.File;

import it.sauronsoftware.ftp4j.FTPClient;

public class FTPManager {
	private FTPClient client;

	public FTPManager() {
		client = new FTPClient();
		client.setCharset("euckr");
	}

	public void connect(String url, int port, String id, String pw) throws Exception {
		client.connect(url, port);
		client.login(id, pw);
	}

	public void disconnect() throws Exception {
		client.disconnect(true);
	}

	public void upload(File file) throws Exception {
		client.upload(file);
	}

	public void download(String fileName, File file) throws Exception {
		client.download(fileName, file);
	}

	public void deleteFile(String fileName) throws Exception {
		client.deleteFile(fileName);
	}

	public String[] listFiles() throws Exception {
		return client.listNames();
	}
}