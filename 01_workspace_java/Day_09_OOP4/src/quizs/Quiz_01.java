package quizs;

import java.util.Scanner;

import classes.Student;

public class Quiz_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student[] students = new Student[3];
		for (int i = 0; i < students.length; i++) {
			// 학번
			students[i] = new Student();
			while (true) {
				try {
					System.out.println(i + 1 + "번째 학생 학번 : ");
					students[i].setId(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
				}
			}

			// 이름
			System.out.println(i + 1 + "번째 학생 이름 : ");
			students[i].setName(sc.nextLine());
			// 국어
			while (true) {
				try {
					System.out.println(students[i].getName() + " 학생 국어 : ");
					students[i].setKor(Integer.parseInt(sc.nextLine()));
					break;
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
				}
			}
			// 영어
			while (true) {
				try {
					System.out.println(students[i].getName() + " 학생 영어 : ");
					students[i].setEng(Integer.parseInt(sc.nextLine()));
					break;
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
				}
			}
			// 수학
			while (true) {
				try {
					System.out.println(students[i].getName() + " 학생 수학 : ");
					students[i].setMath(Integer.parseInt(sc.nextLine()));
					break;
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
				}
			}
		}
		System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].getId() + "\t" + students[i].getName() + "\t" + students[i].getKor() + "\t"
					+ students[i].getEng() + "\t" + students[i].getMath() + "\t" + students[i].getSum() + "\t"
					+ students[i].getAvg());
		}
	}
}
