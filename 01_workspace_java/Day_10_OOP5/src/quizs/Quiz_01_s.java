package quizs;

import java.util.Scanner;

import classes.Gold;
import dao.AnimalManager;

public class Quiz_01_s {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AnimalManager member = new AnimalManager();
		while (true) {
			System.out.println("<< 회원관리 시스템 >>");
			System.out.println("1. 신규 회원 등록 ");
			System.out.println("2. 회원 목록 출력");
			System.out.println("0. 시스템 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				System.out.println("id를 입력해주세요");
				String id = sc.nextLine();
				System.out.println("이름을 입력해주세요");
				String name = sc.nextLine();
				System.out.println("포인트를 입력해주세요");
				int point = Integer.parseInt(sc.nextLine());
				member.addMeber(new Gold(id, name, point));
			} else if (menu == 2) {
				Gold[] members = member.getMembers();
				if (member.getIndex() == 0) {
					System.out.println("조회 목록이 없습니다.");
					continue;
				}
				System.out.println("id\t이름\t포인트\t보너스");
				for (int i = 0; i < member.getIndex(); i++) {
					System.out.println(members[i].getId() + "\t" + members[i].getName() + "\t" + members[i].getPoint()
							+ "\t" + members[i].getBonus());
				}
			} else if (menu == 0) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("번호를 재입력 해주세요.");
			}
		}
	}
}
