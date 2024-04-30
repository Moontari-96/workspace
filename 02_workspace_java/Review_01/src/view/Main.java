package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.CafeDAO;
import dto.CafeDTO;


public class Main {
	// caller method
	// main method는 예외를 전가해선 안 된다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CafeDAO dao = new CafeDAO();
		
		// 카페 메뉴 관리 시스템
		// 디자인패턴 : MV 패턴 적용
		
		// CafeDTO 
		// 멤버필드 : id, name, price
		// 멤버메서드 : getter / setter / constructor / default constructor
		
		
		// CafeDAO
		// 멤버필드 : menus 컬렉션
		// 멤버메서드 : CRUD 기능을 모두 구현
		
		// Main
		// 1. 신규 메뉴 등록
		// 2. 메뉴 목록 출력
		// 3. 메뉴 정보 검색 ( name 으로 검색 )
		// 4. 메뉴 삭제 ( ID로 삭제 )
		// 5. 메뉴 수정 ( ID로 수정 : 수정 대상은 ID를 제외한 모든 항목 )
		// 0. 시스템 종료
		
		while (true) {
			System.out.println("Main");
			System.out.println("1. 신규 메뉴 등록");
			System.out.println("2. 메뉴 목록 출력");
			System.out.println("3. 메뉴 정보 검색");
			System.out.println("4. 메뉴 삭제");
			System.out.println("5. 메뉴 수정");			
			System.out.println("0. 시스템 종료");			
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());
			try {
				if (menu == 1) {
					System.out.print("이름 : ");
					String name = sc.nextLine();
					System.out.print("가격 : ");
					int price = Integer.parseInt(sc.nextLine());
					CafeDTO dto = new CafeDTO(name,price);
					dao.inDB(dto);
					System.out.println("");
				} else if (menu == 2) {
					System.out.println("ID\t이름\t가격");
					List<CafeDTO> list = dao.checkDB();
					for (CafeDTO dto : list) {
						System.out.println(dto.getId()+ "\t" + dto.getName() + "\t" + dto.getPrice());
					}
					System.out.println("");
				} else if (menu == 3) {
					System.out.print("검색할 이름을 입력하세요 ");
					String target = sc.nextLine();
					List<CafeDTO> list = dao.searchDB(target);
					if (list.size() == 0) {
						System.out.println("출력할 내용이 없습니다.");
						System.out.println("");
						continue;
					} else {
						for (CafeDTO dto : list) {
							System.out.println(dto.getId()+ "\t" + dto.getName() + "\t" + dto.getPrice());
						}
					}
					System.out.println("");
				} else if (menu == 4) {
					System.out.print("삭제할 ID를 입력하세요 ");
					int target = Integer.parseInt(sc.nextLine());
					int result = dao.delDB(target);
					if (result > 0) {
						System.out.println("삭제하였습니다.");
						System.out.println("");
					} else {
						System.out.println("삭제 할 대상이 없습니다.");
					}
					
				} else if (menu == 5) {
					System.out.print("수정할 ID를 입력하세요 ");
					int id = Integer.parseInt(sc.nextLine());
					boolean validation = dao.validationDB(id);
					if (validation) {
						System.out.print("이름을 입력하세요 : ");
						String name = sc.nextLine();
						System.out.print("가격을 입력하세요 : ");
						int price = Integer.parseInt(sc.nextLine());
						int result = dao.changeDB(new CafeDTO(id, name, price));
						if (result > 0) {
							System.out.println("수정되었습니다.");
							System.out.println("");
						}
					} else {
						System.out.println("변경할 ID를 찾지 못했습니다.");
					}
					
				} else if (menu == 0) {
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				} else {
					
				}
				}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("오류가 발생했습니다. 같은 오류가 반복되면 관리자에게 문의하세요.");
			}
		}
	}
}
