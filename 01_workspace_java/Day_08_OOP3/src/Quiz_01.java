import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPFile;

public class Quiz_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FTPClient client = new FTPClient();
		client.setCharset("euckr");

		while (true) {

			first: try { // disconnect 시 초기 화면 복귀
				// 초기 번호 입력
				System.out.println("=== FTP Client Program ===");
				System.out.println("1.Connect FTP Server");
				System.out.println("2.Exit Program");
				System.out.print(">>> ");
				int menu = Integer.parseInt(sc.nextLine());
				if (menu == 1) {
					try {
						while (true) {
							System.out.println("");
							System.out.println("input IP");
							System.out.print(">>> ");
							String url = sc.nextLine();
							client.connect(url);
							System.out.println("input port");
							System.out.print(">>> ");
							int port = Integer.parseInt(sc.nextLine());
							if (port == 21) {
								System.out.println("FTP Server is connected");
								System.out.println("");
								System.out.println("input id : ");
								String id = sc.nextLine();
								System.out.println("input password : ");
								String pw = sc.nextLine();
								client.login(id, pw);
								System.out.println("Login Success!");
								while (true) {
									try {
										System.out.println("==================");
										System.out.println("1. Upload File");
										System.out.println("2. Download File");
										System.out.println("3. Disconnect FTP Server");
										System.out.println("4. Delete File");
										System.out.print(">>> ");
										menu = Integer.parseInt(sc.nextLine());
										if (menu == 1) {
											try {
												System.out.println("파일명을 입력해주세요.");
												System.out.print(">>> ");
												File upLoad = new File(sc.nextLine());
												client.upload(upLoad);
												System.out.println("");
											} catch (Exception e) {
												e.printStackTrace();
											}
										} else if (menu == 2) {
											try {
												System.out.println("다음 목록중에 고르세요.");
												String[] files = client.listNames();
//												for (FTPFile file : files) {
//													System.out.println(file.getName());
//												}
												for (int i = 0; i < files.length; i++) {
													System.out.println(files[i]);
												}
												System.out.println("파일 주소를 입력해주세요.");
												String fileName = sc.nextLine();
												String fileAddress = sc.nextLine();
												client.download(fileName, new File(fileAddress));
											} catch (Exception e) {
												e.printStackTrace();
											}
										} else if (menu == 3) {
											try {
												client.disconnect(true);
												break first;
											} catch (Exception e) {
												e.printStackTrace();
											}
										} else if (menu == 4) {
											try {
												System.out.println("다음 목록중에 고르세요.");
												FTPFile[] files = client.list();
												for (FTPFile file : files) {
													System.out.println(file.getName());
												}
												String fileName = sc.nextLine();
												client.deleteFile(fileName);
											} catch (Exception e) {
												e.printStackTrace();
											}

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
							} else {
								System.out.println("Port 넘버를 확인해주세요.");
								System.out.println("");
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				} else if (menu == 2) {
					System.out.println("프로그램을 종료합니다.");
					System.out.println("");
					System.exit(0);
				} else {
					System.out.println("숫자를 제대로 입력해주세요.");
					System.out.println("");
				}
			} catch (Exception e) {
				System.out.println("");
				System.out.println("숫자만 입력해주세요.");
			}
		}

	}
}
