package quizs;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MusicDAO;
import dto.MusicDTO;

public class Main_1 {
//	* Melon 관리 시스템
//	1. 신규 음악 등록
//	2. 음악 목록 출력
//	3. 음악 검색 ( 제목으로 검색 )
//	4. 항목 삭제 ( ID로 삭제 ) 
//	5. 항목수정 ( ID로 수정 / ID를 제외한 전체 항목 수정 )
//	0. 시스템 종료
//	
//	* 조건1. MVC 패턴에서 MV 기반으로 작성할 것
//	* 필요 클래스
//	1> main.Main( View ) 클래스
//	2> dao.MusicDAO 클래스
//	- 멤버필드 : 데이터 저장용 컬렉션
//	- 멤버메서드 : 입력 / 수정 / 삭제 / 조회 / 검색 ( DAO에서 검색을 수행한 결과만 Main으로 반환 )
//  3> dto.MusicDTO 클래스
//	- 멤버필드 : id / title / singer
//	- 멤버메서드 : getter / setter / constructor / default constructor 
//	* 출력형식
//	ID	제목	가수
//	1001 좋은날 아이유
//	1002 ... ...
//	Optiona1
//	- Date write_date 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MusicDAO manager = new MusicDAO();
		while (true) {
			System.out.println("<< Melon 관리 시스템 >>");
			System.out.println("1. 신규 음악 등록");
			System.out.println("2. 음악 목록 출력");
			System.out.println("3. 음악 검색");
			System.out.println("4. 항목 삭제");
			System.out.println("5. 항목수정");
			System.out.println("0. 시스템 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				System.out.print("ID : ");
				String id = sc.nextLine();
				System.out.print("TITLE : ");
				String title = sc.nextLine();
				System.out.print("SINGER : ");
				String singer = sc.nextLine();
				String date = manager.writedate();
				System.out.println("");
				manager.addMusic(new MusicDTO(id, title, singer, date));
			} else if (menu == 2) {
				ArrayList<MusicDTO> music = manager.getMusic();
				System.out.println("ID\t제목\t가수\t작성기간");
				for (MusicDTO list : music) {
					System.out.println(
							list.getId() + "\t" + list.getTitle() + "\t" + list.getSinger() + "\t" + list.getDate());
					System.out.print("");
				}
			} else if (menu == 3) {
				// 음악 검색
				System.out.print("검색할 음악 제목을 입력하세요.");
				String title = sc.nextLine();
				ArrayList<MusicDTO> result = manager.searchMusic(title);
				if (result.size() == 0) {
					System.out.println("검색 대상을 찾을 수 없습니다.");
				} else {
					System.out.println("ID\t제목\t가수\t작성기간");
					for (MusicDTO list : result) {
						System.out.println(list.getId() + "\t" + list.getTitle() + "\t" + list.getSinger() + "\t"
								+ list.getDate());
						System.out.print("");
					}
				}
			} else if (menu == 4) {
				ArrayList<MusicDTO> music = manager.getMusic();
				System.out.println("ID\t제목\t가수\t작성기간");
				for (MusicDTO list : music) {
					System.out.println(
							list.getId() + "\t" + list.getTitle() + "\t" + list.getSinger() + "\t" + list.getDate());
					System.out.print("");
				}
				System.out.print("삭제할 ID를 입력하세요.");
				String id = sc.nextLine();
				if (manager.removeMusic(id) == true) {
					System.out.println("삭제 성공!!");
				} else {
					System.out.println("삭제할 대상이 없습니다.");
				}
			} else if (menu == 5) {
				ArrayList<MusicDTO> music = manager.getMusic();
				System.out.println("ID\t제목\t가수\t작성기간");
				for (MusicDTO list : music) {
					System.out.println(
							list.getId() + "\t" + list.getTitle() + "\t" + list.getSinger() + "\t" + list.getDate());
					System.out.print("");
				}
				System.out.print("수정할 ID를 입력하세요.");
				String id = sc.nextLine();
				System.out.print("TITLE : ");
				String title = sc.nextLine();
				System.out.print("SINGER : ");
				String singer = sc.nextLine();
				String date = manager.writedate();
				MusicDTO modify = new MusicDTO(id, title, singer, date);
				if (manager.modifyMusic(modify) == true) {
					System.out.println("수정완료!!");
				} else {
					System.out.println("ID를 확인해주세요.");
				}
			} else if (menu == 0) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("번호를 확인하고 입력해주세요.");
				System.out.println("");
			}

		}
	}
}
