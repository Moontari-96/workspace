//	대화형 프로그램 기초 예제
public class Exam_01 {
	public static void main(String[] args) throws Exception {
		System.out.println("한 글자를 입력해주세요."); // 원초적인 UI 구성
		int num = System.in.read(); // return되어 돌아옴, 사용자가 입력한 값을 대입하는 코드
		System.out.println("입력하신 문자" + (char) num + "의 ASCII 코드 10진수는" + num + " 입니다."); // 사용자 입력값
	}
}
