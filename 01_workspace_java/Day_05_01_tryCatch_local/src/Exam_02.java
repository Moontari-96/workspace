
public class Exam_02 {
	public static void main(String[] args) {

		// 변수의 종류
		// 지역변수 / 정적변수 / 멤버변수
		// Local Variable ( 지역변수 )

		// 지역변수 : 자신이 속한 지역 {} 내에서만 생존할 수 있다.

		int a = 100; // 자신의 하위 지역에도 영향을 줌.

		{ // 가 지역
//			int a = 10;
			System.out.println(a);
		}

		{ // 나지역
//			int a = 20; // 지역이 다르기 때문에 변수 중복이 가능
			System.out.println(a);
		}

	}
}
