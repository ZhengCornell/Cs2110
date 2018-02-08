
public class Rec1 {
	public static boolean containsVowel(String s) {
		if (s.contains("i")||s.contains("a")||s.contains("e")||s.contains("o")||s.contains("u")) {
			return true;	
		}
		return false;
	}
	
	public static String dateToString(int m, int d, int y) {
		String month, ans;
		switch(m) {
		case 1:  month = "January";
		break;
		case 2:  month = "February";
		break;
		case 3:  month = "March";
		break;
		case 4:  month = "April";
		break;
		case 5:  month = "May";
		break;
		case 6:  month = "June";
		break;
		case 7:  month = "July";
		break;
		case 8:  month = "August";
		break;
		case 9:  month = "September";
		break;
		case 10: month = "October";
		break;
		case 11: month = "November";
		break;
		case 12: month = "December";
		break;
		default: month = "Invalid month";
		break;
		}
		ans = month + " " + d + ", "+ y;
		return ans;
	}

	public static String removeDups(String s) {
		if(s.length() <= 0) {
			throw new IllegalArgumentException();
		}else {
			int i = 0, j, N = s.length();
			StringBuilder sb = new StringBuilder();
			sb.append(s.charAt(0));
				for(j = i + 1; j < N; j++) {
					if(s.charAt(i) == s.charAt(j)) {
						j++;
						if(j == N) {
							return sb.toString();
						}else {
							continue;	
						}
					} else {
						i = j;
						sb.append(s.charAt(i));
					}
				}
			return sb.toString();
		}
	}
	
	public static void main(String args[]) {
		System.out.println(containsVowel("Hello World!"));
		System.out.println(dateToString(1, 1, 2000));
		System.out.println(removeDups("aaabbbcabbbbdderffaaaaa"));
		System.out.println(removeDups(""));
	}

}
