package quizs;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Gold;
import classes.Member;
import classes.Silver;
import dao.MemberDAO;

public class Main {
	// * 회원관리 시스템
	// > Main ( View ) - 화면 구성
	// << 회원 관리 시스템 >>
	// 1. 신규 회원 등록
	// 2. 회원 목록 출력
	// 0. 시스템 종료

	// > Silver - 데이터 저장용
	// > 멤버필드 : id / name / point
	// > 멤버메서드 : setter & getter / constructor / default constructor /
	// getBonus : 멤버의 point 값 * 0.02 를 반환
	////
	// > MemberManager - 데이터 관리용
	// > Silver 인스턴스를 최대 10개까지 저장할 수 있는 배열 members, index = 0
	// > 멤버메서드 : addMember, getMembers

	// 현 회원관리 시스템의 치명적인 문제점 3가지
	// 1. 코드 중복도 - 상속( IS - A 관계 )을 이용해서 해결
	// A is a B : A는 B이다.
	// ex> Bear is a [ ]
	// ex> Lion is a [ ]
	// 상속은 하나의 클래스만 가능하다. A extends B, C 는 불가
	// A를 상속받은 B를 상속받은 C를 만드는 다중상속은 가능

	// 2. 코드 결합도 - 다형성을 이용해서 해결

	// 3. 저장소 문제 - 컬렉션을 이용해서 해결

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberDAO manager = new MemberDAO();
		while (true) {
			System.out.println("<< 회원 관리 시스템 >>");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 목록 출력");
			System.out.println("0. 시스템 종료");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				// Silver, Gold 같은 클래스 = DTO(Data Transfer Object)
				manager.addMember(new Silver("1002", "Susan", 2000));
				manager.addMember(new Silver("1002", "Susan", 2000));
				manager.addMember(new Gold("1003", "Mike", 3000));
				System.out.println();
				// System.out.print("ID : ");
				// String id = sc.nextLine();
				// System.out.print("Name : ");
				// String name = sc.nextLine();
				// System.out.print("Point : ");
				// int point = Integer.parseInt(sc.nextLine());
				//
				// Silver s = new Silver(id, name, point);
				// manager.addMember(new Silver(id, name, point));
			} else if (menu == 2) {
				ArrayList<Member> members = manager.getMember();

				// 배열값 불러오기
				// if (manager.getIndex() == 0) {
				// System.out.println("조회 목록이 없습니다.");
				// continue;
				// }
				System.out.println("ID\tName\tPoint\tBonus");
				// for (int i = 0; i < members.size(); i++) {
				// System.out.println(members.add(i). + "\t" + members[i].getName() + "\t" +
				// members[i].getPoint()
				// + "\t" + members[i].getBonus());
				// System.out.println(members.get(i).getId() + "\t" + members.get(i).getName() +
				// "\t"
				// + members.get(i).getPoint() + "\t" + members.get(i).getBonus());
				// }

				for (Member m : members) {
					System.out.println(m.getId() + "\t" + m.getName() + "\t" + m.getPoint() + "\t" + m.getBonus());
				}

			} else if (menu == 0) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("번호를 재입력해주세요.");
			}
		}
	}
}
