import java.util.Scanner;

public class Quiz_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[3];
		int[] kor = new int[3];
		int[] eng = new int[3];
		int[] sum = new int[3];
		double[] avg = new double[3];
		for (int i = 0; i < name.length; i++) {
			System.out.print((i + 1) + "번째 학생 이름 : ");
			name[i] = sc.nextLine();
			System.out.print(name[i] + "학생 국어 :");
			kor[i] = Integer.parseInt(sc.nextLine());
			System.out.print(name[i] + "학생 영어 :");
			eng[i] = Integer.parseInt(sc.nextLine());
			sum[i] = kor[i] + eng[i];
			avg[i] = sum[i] / 2.0;
		}
		System.out.println("이름 국어 영어 합계 평균");
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i] + " " + kor[i] + " " + eng[i] + " " + sum[i] + " " + avg[i]);
		}

	}
}
