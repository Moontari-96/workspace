package exams;

import classes.Product;

public class Exam_01 {
	// Product 클래스 제작
	// 1. 정보은닉 / getter&setters / constructor / default constructor 모두 작성
	// 2. 멤버필드 : 상품코드 / 상품명 / 가격 / 재고

	// Product 설계도 기반 인스턴스 3개를 생성하고 ( 데이터는 자유 선택 )
	// 저장된 모든 데이터를 화면에 출력해보기.
	public static void main(String[] args) {
		Product[] store = new Product[3];
		store[0] = new Product(1000, "허니버터칩", 1800, 20);
		store[1] = new Product();
		store[1].setCode(1001);
		store[1].setProductName("스윙칩");
		store[1].setPrice(1500);
		store[1].setInventory(10);
		store[2] = new Product(1002, "포카칩", 1500, 15);
		for (int i = 0; i < store.length; i++) {
			System.out.println(store[i].getCode());
			System.out.println(store[i].getProductName());
			System.out.println(store[i].getPrice());
			System.out.println(store[i].getInventory());
			System.out.println("");
		}

		Product[] products = new Product[] { new Product(1000, "허니버터칩", 1800, 20), new Product(1001, "스윙칩", 1500, 15),
				new Product(1002, "포카칩", 1500, 15) };

		System.out.println("상품코드\t상품명\t가격\t재고");
		for (int i = 0; i < products.length; i++) {
			System.out.println(store[i].getCode() + "\t" + store[i].getProductName() + "\t" + store[i].getPrice() + "\t"
					+ store[i].getInventory());
		}
	}

}
