import java.io.File;
import java.util.Scanner;

public class FTPClientApp {

	private Scanner scanner;
	private FTPManager ftpManager;

	public FTPClientApp() {
		scanner = new Scanner(System.in);
		ftpManager = new FTPManager();
	}

	public void start() {
		try {
			System.out.println("=== FTP Client Program ===");
			System.out.println("1. Connect FTP Server");
			System.out.println("2. Exit Program");

			int menu = Integer.parseInt(scanner.nextLine());
			if (menu == 1) {
				connectToFTPServer();
			} else if (menu == 2) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("숫자를 제대로 입력해주세요.");
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("");
			System.out.println("숫자만 입력해주세요.");
		}
	}

	private void connectToFTPServer() {
		try {
			System.out.println("");
			System.out.println("Input URL");
			System.out.print(">>> ");
			String url = scanner.nextLine();

			System.out.println("Input Port");
			System.out.print(">>> ");
			int port = Integer.parseInt(scanner.nextLine());

			if (port != 21) {
				System.out.println("Port 넘버를 확인해주세요.");
				System.out.println("");
				return;
			}

			System.out.println("Input ID");
			System.out.print(">>> ");
			String id = scanner.nextLine();

			System.out.println("Input Password");
			System.out.print(">>> ");
			String pw = scanner.nextLine();

			ftpManager.connect(url, port, id, pw);
			System.out.println("FTP Server is connected");

			showMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showMenu() {
		try {
			while (true) {
				System.out.println("==================");
				System.out.println("1. Upload File");
				System.out.println("2. Download File");
				System.out.println("3. Disconnect FTP Server");
				System.out.println("4. Delete File");
				System.out.print(">>> ");

				int menu = Integer.parseInt(scanner.nextLine());

				switch (menu) {
				case 1:
					uploadFile();
					break;
				case 2:
					downloadFile();
					break;
				case 3:
					disconnectFromFTPServer();
					break;
				case 4:
					deleteFile();
					break;
				default:
					System.out.println("숫자를 제대로 입력해주세요.");
					System.out.println("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("");
			System.out.println("숫자만 입력해주세요.");
		}
	}

	private void uploadFile() {
		try {
			System.out.println("Enter file name to upload");
			System.out.print(">>> ");
			File uploadFile = new File(scanner.nextLine());
			ftpManager.upload(uploadFile);
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void downloadFile() {
		try {
			System.out.println("Select a file from the following list:");
			String[] files = ftpManager.listFiles();
			for (String file : files) {
				System.out.println(file);
			}

			System.out.println("Enter the file name to download:");
			System.out.print(">>> ");
			String fileName = scanner.nextLine();

			System.out.println("Enter the file address to save:");
			System.out.print(">>> ");
			String fileAddress = scanner.nextLine();

			ftpManager.download(fileName, new File(fileAddress));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void disconnectFromFTPServer() {
		try {
			ftpManager.disconnect();
			System.out.println("FTP Server is disconnected");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteFile() {
		try {
			System.out.println("Select a file from the following list:");
			String[] files = ftpManager.listFiles();
			for (String file : files) {
				System.out.println(file);
			}

			System.out.println("Enter the file name to delete:");
			System.out.print(">>> ");
			String fileName = scanner.nextLine();

			ftpManager.deleteFile(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FTPClientApp app = new FTPClientApp();
		app.start();
	}

}
