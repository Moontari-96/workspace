package view;

import java.util.List;
import java.util.Scanner;

import dao.ContactDAO;
import dto.ContactDTO;

public class Contact {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ContactDAO dao = new ContactDAO();
		while(true) {
			System.out.println("<< 연락처 >>");
			System.out.println("1. 신규 등록");
			System.out.println("2. 목록 출력");
			System.out.println("3. 항목 삭제");
			System.out.println("4. 항목 수정");
			System.out.println("5. 항목 검색");
			System.out.println("0. 종료");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());
			try {
				if (menu == 1) {
					System.out.println("이 름 : ");
					String name = sc.nextLine();
					
					System.out.println("전화 번호 : ");
					String phone = sc.nextLine();
					
					dao.addContact(new ContactDTO(0, name, phone, null));
				} else if (menu == 2) {
					List<ContactDTO> list = dao.selectContact();
					System.out.println("ID\t이름\t전화번호\tRegDate");
					for (ContactDTO dto : list) {
						System.out.println(dto.getId() + "\t" + dto.getName() + "\t" + dto.getPhone() + "\t" + dto.getFormedDate())  ;
					}
				System.out.println("");
				} else if (menu == 3) {
					System.out.println("삭제할 ID를 입력하세요.");
					int target = Integer.parseInt(sc.nextLine());
					
					int result = dao.deleteContact(target);
					if (result == 0) {
						System.out.println("삭제할 대상이 없습니다.");
						System.out.println("");
					} else {
						System.out.println("삭제 성공했습니다.");
						System.out.println("");
					}
				} else if (menu == 4) {
					System.out.println("수정할 ID를 입력하세요. ");
					int id = Integer.parseInt(sc.nextLine());
					if (dao.valdationContact(id)) {
						System.out.println("수정할 이름 : ");
						String name = sc.nextLine();
						
						System.out.println("수정할 번호 : ");
						String phone = sc.nextLine();
						int result = dao.changeContact(new ContactDTO(id,name,phone,null));
						if (result > 0) {
							System.out.println("수정에 성공했습니다!!");
							System.out.println("");
						}
					} else {
						System.out.println("ID를 확인해 주세요.");
						System.out.println("");
					}
					
				} else if (menu == 5) {
					System.out.println("검색할 이름를 입력하세요. ");
					String target = sc.nextLine();
					List<ContactDTO> list = dao.searchContact(target);
					if (list.size() != 0) {
						System.out.println("ID\t이름\t전화번호\tRegDate");
						for (ContactDTO dto : list) {
							System.out.println(dto.getId() + "\t" + dto.getName() + "\t" + dto.getPhone() + "\t" + dto.getFormedDate());
						}
						System.out.println("");
					} else {
						System.out.println("찾으려는 대상이 없습니다.");
						System.out.println("");
					}
					
				} else if (menu == 0){
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("숫자를 제대로 입력해주십시오.");
				}
				
			} catch (Exception e) {
				e.printStackTrace(); // 개발자가 보는 에러 메세지
				System.out.println("오류로 인한 장애가 발생했습니다. 관리자 문의 부탁드립니다.");
			}
		}
	}
}
