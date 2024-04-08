package Model;

import classes.Student;

// 데이터 전담 관리 클래스
public class StudentManager {
	private Student[] stds = new Student[10];
	private int index = 0;

	public void addStudent(Student std) {
		this.stds[index++] = std;
	}

	public Student[] getStds() {
		return stds;
	}

	public int getIndex() {
		return index;
	}
}
