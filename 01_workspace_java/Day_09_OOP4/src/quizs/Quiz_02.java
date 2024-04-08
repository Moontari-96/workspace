package quizs;

import java.util.Scanner;

import Model.StudentManager;
import classes.Student;

public class Quiz_02 {
	public static void main(String[] args) {

		// MVC (Model View Design)
		// M - Model : 데이터를 관리하는 소스코드 집합.
		// V - View : 시각요소를 관리하는 소스코드 집합.
		// C - Control : 프로그램 흐름을 관리하는 소스코드 집합

		Scanner sc = new Scanner(System.in);
		StudentManager manager = new StudentManager();
		// 학생 정보 입력은 최대 10명까지

		while (true) {
			System.out.println("<< 학생 관리 시스템 >>");
			System.out.println("1. 신규 정보 입력"); // Create
			System.out.println("2. 학생 목록 출력"); // Read
			System.out.println("3. 학생 정보 검색"); // 검색할 학생 이름 : 홍길동
			System.out.println("0. 시스템 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {

				System.out.print("학번 입력 : ");
				String id = sc.nextLine();

				System.out.print("학생 이름 : ");
				String name = sc.nextLine();

				System.out.print(name + " 학생의 국어 : ");
				int kor = Integer.parseInt(sc.nextLine());

				System.out.print(name + " 학생의 영어 : ");
				int eng = Integer.parseInt(sc.nextLine());

				System.out.print(name + " 학생의 수학 : ");
				int math = Integer.parseInt(sc.nextLine());

				manager.addStudent(new Student(id, name, kor, eng, math));

			} else if (menu == 2) {
				Student[] stds = manager.getStds();

				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");

				for (int i = 0; i < manager.getIndex(); i++) {
					System.out.println(stds[i].getId() + "\t" + stds[i].getName() + "\t" + stds[i].getKor() + "\t"
							+ stds[i].getEng() + "\t" + stds[i].getMath() + "\t" + stds[i].getSum() + "\t"
							+ stds[i].getAvg());
				}

			} else if (menu == 3) {
				System.out.println("검색할 학생 이름 : ");
				String name = sc.nextLine();

				Student[] stds = manager.getStds();
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");

				for (int i = 0; i < manager.getIndex(); i++) {
					if (stds[i].getName().contains(name))
						System.out.println(stds[i].getId() + "\t" + stds[i].getName() + "\t" + stds[i].getKor() + "\t"
								+ stds[i].getEng() + "\t" + stds[i].getMath() + "\t" + stds[i].getSum() + "\t"
								+ stds[i].getAvg());
				}
			} else if (menu == 0) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			} else {
			}
		}
	}
}

// java.lang.NullPointerException : 가장 많이 발생하는 에러 값