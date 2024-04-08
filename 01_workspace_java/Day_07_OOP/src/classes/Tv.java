package classes;

// 정보은닉 / 접근제한자 / getter / setter / constructor / static

// 정보은닉을 지키며 클래스를 작성할 것
// 접근제한자 : public ( 공개 범위가 넓음, 어디서든 사용 가능 ) / protected / package ( 폴더와 같음, 폴더의 기능, 분리 및 관리 용이, 자신과 같은 package 안에 소스코드는 접근 허용 그 외는 접근제한) / private ( 어디서든 접근 제한, 접근 범위가 좁음, 클래스 내부에서만 사용가능 {}안 ) 
// 사용빈도 : public과 private을 많이 씀
// 정보은닉 사용목적 : 클래스 개발자의 안정성과 클래스 사용자의 편의성을 위함 

public class Tv {

	// 멤버 필드 ( 속성 ) / 변수를 자바에서는 field라고도 함. variable ( 변수 )
	// 접근제한자 기본값은 package
	// field 생성 시 private붙여서 생성
	private int price; // Member field는 Heap메모리에 생성된다.
	private int channel; // <-- 16 을 대입
	private int volume; // <-- 20 을 대입

	// 멤버 메서드 ( 기능 ) / 클래스 개발자가 메서드를 통해 통제 및 안정성 확보를 할 수 있음 / public 통해서 인스턴스 전달
	// 필드 하나당 최소 2개의 메서드가 필요
	// 매개변수 및 지역변수는 Stack 메모리에 생성된다.
	// public void setPrice(int price) {
	// get set 메서드 출력 단축키
	// alt + shift + s + r
	// alt + a
	// alt + r

	public int getPrice() {
		// 값을 꺼내오는 메서드 명 get + 해당 field명
		// get이라는 이름이 붙으면 리턴값 존재, 매개변수는 필요없음.s
		return price;
	}

	public void setPrice(int price) {
		// 외부의 값을 멤버 필드에 집어 넣는 메서드
		// 값을 넣는 메서드 명 set + 해당 field명
		// set이라는 이름이 붙으면 리턴값 존재 X (void), 매개변수는 필요함
		// 멤버필드의 변수들은 Heap메모리에 만들어지고 매개변수는 stack에 만들어지기때문에 중첩 가능
		// price = price; stack메모리가 우선이라 매개변수 = 매개변수 자전대입
		// this : 자기 참조 변수 -> Exam03의 lg 변수와 같은 값을 가진다.
		this.price = price; // this는 클래스 멤버를 뜻함
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Tv getThis() {
		return this;
	}

	// 생성자 ( Constructor ) : 메서드의 한 종류로 몇가지 특이한 규칙을 가진다.
	// 1. 생성자 메서드의 이름은 클래스 이름과 같아야 한다.
	// 2. 메서드 호출 시점을 자유롭게 정할 수 없다. ( 불려지는 시점이 정해져 있음 )
	// 3. 생성자 메서드는 반환값을 가지지 않는다. ( return 값이 없음 )
	// 4. 기타 모든 규칙은 일반 메서드와 동일 하다. ( 매개변수, 접근제한자 )
	// 인스턴스가 실행될 때 실행됨
	// 초기값 넣는 코드로 사용
	// source 내 generate 사용하면 한번에 생성가능
	// 생성자는 생성안할 시 자동생산됨

	public Tv() {
		// Default Constructor
		// Over loading 문법
	}

	public Tv(int price, int channel, int volume) {
		this.price = price;
		this.channel = channel;
		this.volume = volume;
	}

	// Nested Class ( 중첩 클래스 )

}
