package quizs;

import java.util.Scanner;

import Model.ContactManager;
import classes.Contact;

public class Quiz_03 {
	public static void main(String[] args) {
		// * 연락처 관리 프로그램
		// 클래스 이름 : Contact
		// id / name / phone
		// 멤버메서드 : getter&setter / constructor / default constructor

		// CRUD 중 C, R 기능을 구현
		// 이름 기반의 검색 기능 구현.
		// 1. 신규 연락처 등록
		// 2. 연락처 목록 출력
		// 3. 연락처 검색

		// Optional. 연락처 삭제 (ID로) / 연락처 수정 (ID로)

		Scanner sc = new Scanner(System.in);
		ContactManager cont = new ContactManager();
		while (true) {
			System.out.println("==== 연락처 관리 프로그램 ====");
			System.out.println("1. 신규 연락처 등록"); // C
			System.out.println("2. 연락처 목록 출력"); // R
			System.out.println("3. 연락처 검색"); // R
			System.out.println("4. 연락처 삭제"); // D
			System.out.println("5. 연락처 수정"); // U
			System.out.println("0. 프로그램 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {

				System.out.print("ID 입력 : ");
				String id = sc.nextLine();

				System.out.print("이름 입력 : ");
				String name = sc.nextLine();

				System.out.print("번호 입력 : ");
				String phone = sc.nextLine();

				cont.addContact(new Contact(id, name, phone));

			} else if (menu == 2) {
				if (cont.ContIndex() == 0) {
					System.out.println("등록된 연락처가 없습니다.");
					continue;
				}
				Contact[] conts = cont.getCont();
				System.out.println("ID\t이름\t번호");
				for (int i = 0; i < cont.ContIndex(); i++) {
					System.out.println(conts[i].getId() + "\t" + conts[i].getName() + "\t" + conts[i].getPhone());
				}
			} else if (menu == 3) {
				int count = 0;
				Contact[] conts = cont.getCont();
				System.out.print("검색할 이름을 입력하세요 : ");
				String name = sc.nextLine();
				for (int i = 0; i < cont.ContIndex(); i++) {
					if (conts[i].getName().contains(name))
						System.out.println(conts[i].getId() + "\t" + conts[i].getName() + "\t" + conts[i].getPhone());
					count++;
				}
				if (count == 0) {
					System.out.println("검색 내용이 없습니다.");
				}
			} else if (menu == 4) {
				Contact[] conts = cont.getCont();
				System.out.println("ID\t\t이름\t\t번호");
				for (int i = 0; i < cont.ContIndex(); i++) {
					System.out.println(conts[i].getId() + "\t" + conts[i].getName() + "\t" + conts[i].getPhone());
				}
				System.out.print("삭제할 ID를 입력하세요 : ");
				String id = sc.nextLine();
				for (int i = 0; i < cont.ContIndex(); i++) {
					if (conts[i].getId().contains(id)) {
						conts[i] = null;
						cont.setIndex(0);
					}
				}
			} else if (menu == 5) {
				Contact[] conts = cont.getCont();
				System.out.println("ID\t\t이름\t\t번호");
				for (int i = 0; i < cont.ContIndex(); i++) {
					System.out.println(conts[i].getId() + "\t" + conts[i].getName() + "\t" + conts[i].getPhone());
				}
				System.out.print("수정할 ID를 입력하세요 : ");
				String id = sc.nextLine();
				for (int i = 0; i < cont.ContIndex(); i++) {
					if (conts[i].getId().contains(id)) {
						System.out.print("수정할 이름을 입력하세요 : ");
						String name = sc.nextLine();
						System.out.print("수정할 번호를 입력하세요 : ");
						String phone = sc.nextLine();
						conts[i].setName(name);
						conts[i].setPhone(phone);
					}
				}
			} else if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("번호 똑디 입력해라 마!!");
			}
		}
	}
}
