
public class Coding_T3 {
	public static void main(String[] args) {
		String s = "1 2 3 4";
		String[] d = s.split(" ");
		int max = 0;
		int min = 0;
		int n;
		min = max = Integer.parseInt(d[0]);
		for (int i = 1; i < d.length; i++) {
			n = Integer.parseInt(d[i]);
			if (min > n)
				min = n;
			if (max < n)
				max = n;
		}
//		s.toCharArray();
		System.out.println(max);
	}
}
