package dao;

import java.text.SimpleDateFormat;

public class NetworkDAO {

	int[] arr = new int[45];

	public String getLotto() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < 50000; i++) {
			int x = (int) (Math.random() * 45);
			int y = (int) (Math.random() * 45);
			int tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;

		}
		return arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5];
	}

	public String getTime() {
		long ctime = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		return sdf.format(ctime);

	}

	public String getQuotes() {
		String result = "";
		int menu = (int) (Math.random() * 3 + 1);
		if (menu == 1) {
			result = "삶의 있는 한 희망은 있다";
		} else if (menu == 2) {
			result = "산다는 것 그것은 치열한 전투이다.";
		} else if (menu == 3) {
			result = "신은 용기있는 자를 결코 버리지 않는다.";
		}
		return result;
	}

}
