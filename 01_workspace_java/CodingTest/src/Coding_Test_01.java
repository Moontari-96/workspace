class Solution {
	public String solution(String[] str_list, String ex) {
		String answer = "";
		int count = 0;
		for (int i = 0; i < str_list.length; i++) {
			if (!str_list[i].contains(ex)) {
				answer += str_list[i];
			}
			if (str_list[i].contains("c")) {
				count++;
				if (count == str_list.length) {
					return "";
				}
			}
		}
		return answer;
	}
}