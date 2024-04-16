package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.StudentDAO;
import dto.StudentDTO;

//학생 관리 시스템

//1. 신규 학생 등록
//2. 학생 목록 출력
//3. 학생 정보 검색 ( 이름으로 검색 )
//4. 학생 정보 삭제 ( ID로 삭제 ) 
//5. 학생 정보 수정 ( ID로 수정 - 이름, 국어, 영어, 수학 - Optional ( 날짜 ) )
//6. 시스템 종료
//
//* 출력 내용
//- 학번 / 이름 / 국어 / 영어 / 수학 / 총점 / 평균 / 날짜
//
//DTO : id / name / kor / eng / math - Optional ( 날짜 )
//	- Getter & Setter / Constructor / Default Constructor
//	- getSum / getAvg
//
//
//DAO : ArrayList<DTO>
//	-CRUD 메서드 및 검색기능

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();
		// 학생 관리 시스템 뷰
		while (true) {
			System.out.println("<< 학생 관리 시스템 >>");
			System.out.println("1. 신규 학생 등록");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 학생 정보 수정");
			System.out.println("6. 시스템 종료");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());
			// 메뉴선택
			if (menu == 1) {
				System.out.print("ID :");
				String id = sc.nextLine();

				System.out.print("이름 :");
				String name = sc.nextLine();

				System.out.print("국어 :");
				int kor = Integer.parseInt(sc.nextLine());

				System.out.print("영어 :");
				int eng = Integer.parseInt(sc.nextLine());

				System.out.print("수학 :");
				int math = Integer.parseInt(sc.nextLine());

				StudentDTO dto = new StudentDTO(id, name, kor, eng, math);
				dao.addStudent(dto);
			} else if (menu == 2) {
				ArrayList<StudentDTO> student = dao.getStudent();
				System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t날짜");
				if (student.size() == 0) {
					System.out.println("학생 정보가 없습니다.");
					continue;
				}
				for (StudentDTO dto : student) {
					System.out.println(dto.getId() + "\t" + dto.getName() + "\t" + dto.getKor() + "\t" + dto.getEng()
							+ "\t" + dto.getMath() + "\t" + dto.getSum() + "\t" + dto.getAvg());
				}
			} else if (menu == 3) {
				ArrayList<StudentDTO> student = dao.getStudent();
				System.out.print("검색하고자 하는 이름을 입력하세요");
				String target = sc.nextLine();
				dao.searchName(target);
				System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t날짜");
				for (StudentDTO dto : dao.searchName(target)) {
					System.out.println(dto.getId() + "\t" + dto.getName() + "\t" + dto.getKor() + "\t" + dto.getEng()
							+ "\t" + dto.getMath() + "\t" + dto.getSum() + "\t" + dto.getAvg());
				}
			} else if (menu == 4) {
				ArrayList<StudentDTO> student = dao.getStudent();
				for (StudentDTO dto : student) {
					System.out.println(dto.getId() + "\t" + dto.getName() + "\t" + dto.getKor() + "\t" + dto.getEng()
							+ "\t" + dto.getMath() + "\t" + dto.getSum() + "\t" + dto.getAvg());
				}
				System.out.print("삭제하고자 하는 ID를 입력하세요");
				String target = sc.nextLine();
				boolean result = dao.deleteID(target);
				if (!result) {
					System.out.println("ID를 확인해주세요.");
				}

			} else if (menu == 5) {
				ArrayList<StudentDTO> student = dao.getStudent();
				System.out.print("수정하고자 하는 ID를 입력하세요.");
				String id = sc.nextLine();
				System.out.print("이름 :");
				String name = sc.nextLine();
				System.out.print("국어 :");
				int kor = Integer.parseInt(sc.nextLine());

				System.out.print("영어 :");
				int eng = Integer.parseInt(sc.nextLine());

				System.out.print("수학 :");
				int math = Integer.parseInt(sc.nextLine());
				StudentDTO dto = new StudentDTO(id, name, kor, eng, math);
				boolean result = dao.changeInfo(dto);
				if (!result) {
					System.out.println("ID를 확인해주세요.");
				}
			} else if (menu == 6) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}
		}
	}
}
