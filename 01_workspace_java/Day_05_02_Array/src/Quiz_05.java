public class Quiz_05 {
	// 로또 당첨 확률 시뮬레이터
	public static void main(String[] args) {
		// 로또 번호 생성
		// 로또 추첨 번호
		int[] lotto = new int[45];
		// 내가 뽑는 자동 번호
		int[] mynum = new int[45];
		// 로또 당첨금 합계 변수
		long sum = 0L;
		// 로또 횟수 카운트
		int ac = 0;
		// 추첨번호와 자동번호 비교
		int count = 0;
		int bonus = 0;
		// 2~5등 당첨횟수 카운트
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		// 1등 당첨 전까지 무한 반복
		while (true) {
			ac++; // 회차 증가
			count = 0; // 초기화
			bonus = 0; // 초기화
			// 1~45 까지 숫자 배열저장
			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = i + 1;
				mynum[i] = i + 1;
			}
			// 로또 번호 셔플
			for (int i = 0; i < 500; i++) {
				int x = (int) (Math.random() * 45);
				int y = (int) (Math.random() * 45);
				int tmp = lotto[x];
				lotto[x] = lotto[y];
				lotto[y] = tmp;
			}

			for (int i = 0; i < 500; i++) {
				int x = (int) (Math.random() * 45);
				int y = (int) (Math.random() * 45);
				int tmp = mynum[x];
				mynum[x] = mynum[y];
				mynum[y] = tmp;
			}
			// 로또 번호 비교 횟수 저장
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if (lotto[i] == mynum[j]) {
						count++; // 같은 값이 있으면 count를 증가시킴
						break;
					}
				}
			}

			if (lotto[6] == mynum[6]) {
				bonus++;
			}
			// 1~5등 및 당첨결과 저장
			System.out.print(ac + " 회차 : " + "( " + lotto[0] + " )" + " " + "( " + lotto[1] + " )" + " " + "( "
					+ lotto[2] + " )" + " " + "( " + lotto[3] + " )" + " " + "( " + lotto[4] + " )" + " " + "( "
					+ lotto[5] + " )" + " + " + "( " + lotto[6] + " )");
			if (count == 6) {
				System.out.println("---------> *** 1등 당첨을 축하합니다.!!!!!!!!! ***");
				sum += 1600000000;
				break;
			} else if (count == 5 && bonus == 1) {
				System.out.println("---------> *** 2등 당첨을 축하합니다. ***");
				count2++;
				sum += 60000000;
			} else if (count == 5) {
				System.out.println("---------> *** 3등 당첨을 축하합니다. ***");
				count3++;
				sum += 1700000;
			} else if (count == 4) {
				System.out.println("---------> *** 4등 당첨을 축하합니다. ***");
				count4++;
				sum += 50000;
			} else if (count == 3) {
				System.out.println("---------> *** 5등 당첨을 축하합니다. ***");
				count5++;
				sum += 5000;
			} else {
				System.out.println("---------> 다음 기회에");
			}
			System.out.print(count2 + " ");
			System.out.print(count3 + " ");
			System.out.print(count4 + " ");
			System.out.print(count5 + " ");
			System.out.println("");
		}
		// 당첨 결과 출력
		System.out.println("===================== 결과 =====================");
		System.out.println(ac + "번 만에 1등에 당첨되셨습니다! :: 1등 수령액 : 1600000000원 :: 당첨확률 :" + ((double) 1) / ac + "%");
		System.out.println("2등 : " + count2 + "번 당첨 :: 2등 당첨금 합계 :" + (((long) 60000000) * count2) + "원" + " :: "
				+ "당첨확률 : " + ((double) count2) / ac + "%");
		System.out.println("3등 : " + count3 + "번 당첨 :: 3등 당첨금 합계 :" + (((long) 1700000) * count3) + "원" + " :: "
				+ "당첨확률 : " + ((double) count3) / ac + "%");
		System.out.println("4등 : " + count4 + "번 당첨 :: 4등 당첨금 합계 :" + (((long) 50000) * count4) + "원" + " :: "
				+ "당첨확률 : " + ((double) count4) / ac + "%");
		System.out.println("5등 : " + count5 + "번 당첨 :: 5등 당첨금 합계 :" + (((long) 5000) * count5) + "원" + " :: "
				+ "당첨확률 : " + ((double) count5) / ac + "%");
		System.out.println("===============================================");
		System.out.println(">> 총 로또 구매 금액 : " + (((long) ac) * 1000) + "원");
		System.out.println(">> 총 당첨 금액 : " + sum + "원");
		System.out.println(sum - (((long) ac) * 1000) + "원을 벌었습니다!");
		System.out.println("===============================================");
	}
}
