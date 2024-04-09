package classes;

// Gold is a [  ]

// Silver is a [  ]
// extends 확장하다.(상속)
// 부모 자식 관계 (상위, 하위 클래스)
// ** 부모 super ** 
// 자식 derived

public class Silver extends Member {
	public Silver() {
	}

	public Silver(String id, String name, int point) {
		super(id, name, point); // 가장 보편적인 방법
		// this.setId(id);
		// this.setName(name);
		// this.setPoint(point);
	}

	// 1. setter 사용
	// 2. 접근제한자 변경 - 비추천 ( 정보은닉 권고안을 위반함 )
	// 3. **Constructor 사용** super();
	public double getBonus() {
		return this.getPoint() * 0.02;
	}
}
