package dao;

import java.util.ArrayList;

import dto.StudentDTO;

public class StudentDAO {
	ArrayList<StudentDTO> student = new ArrayList<>();

	public void addStudent(StudentDTO dto) {
		this.student.add(dto);
	}

	public ArrayList<StudentDTO> getStudent() {
		return student;
	}

	public ArrayList<StudentDTO> searchName(String target) {
		ArrayList<StudentDTO> result = new ArrayList<>();
		for (StudentDTO dto : student) {
			if (dto.getName().contains(target)) {
				result.add(dto);
			}
		}
		return result;
//		for (StudentDTO dto : student) {
//			if (dto.getName().contains(target)) {
//				student.add(dto);
//			}
//		}
//		return  
	}

	public boolean deleteID(String target) {
		for (StudentDTO dto : student) {
			if (dto.getId().equals(target)) {
				student.remove(dto);
				return true;
			}
		}
		return false;
	}

	public boolean changeInfo(StudentDTO dto) {
		for (StudentDTO change : student) {
			if (change.getId().equals(dto)) {
				change.setName(dto.getName());
				change.setKor(dto.getKor());
				change.setEng(dto.getEng());
				change.setMath(dto.getMath());
				return true;
			}
		}
		return false;
	}
}