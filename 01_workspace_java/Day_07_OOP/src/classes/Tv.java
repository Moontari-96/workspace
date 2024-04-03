package classes;

// 정보은닉 / 접근제한자 / getter / setter / constructor / static

// 정보은닉을 지키며 클래스를 작성할 것
// 접근제한자 : public ( 공개 범위가 넓음, 어디서든 사용 가능 ) / protected / package ( 폴더와 같음, 폴더의 기능, 분리 및 관리 용이, 자신과 같은 package 안에 소스코드는 접근 허용 그 외는 접근제한) / private ( 어디서든 접근 제한, 접근 범위가 좁음, 클래스 내부에서만 사용가능 {}안 ) 
// 사용빈도 : public과 private을 많이 씀
// 정보은닉 사용목적 : 클래스 개발자의 안정성과 클래스 사용자의 편의성을 위함 

public class Tv {

	// 멤버 필드 ( 속성 ) / 변수를 자바에서는 field라고도 함. variable ( 변수 )
	// 접근제한자 기본값은 package
	public int price;
	private int channel;
	int volume;

	// 멤버 메서드 ( 기능 ) / 클래스 개발자가 메서드를 통해 통제 및 안정성 확보를 할 수 있음
	void powerOn() {
	}

	void powerOff() {
	}

	public void channelUp() {
		if (channel > 0) {
			channel++;
		}
	}

	public void channelDown() {
		channel--;
	}

	// 생성자 ( Constructor )

	// Nested Class ( 중첩 클래스 )

}
