
public class Coding_T1 {
	public static void main(String[] args) {
		String phone_number = "01033334444";
		char[] ch = phone_number.toCharArray();
		System.out.println(phone_number);
		int lastIdx = phone_number.length() - 4;
		String star = "";
		for (int i = 0; i < lastIdx; i++) {
			star += "*";
		}
		String last_num = phone_number.substring(lastIdx);
	}
}
