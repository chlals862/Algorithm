package CodeUp.문자열;

import java.util.Scanner;

public class _2721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		String str3 = sc.next();
		
		if(str1.charAt(str1.length()-1) == str2.charAt(0) &&
				str2.charAt(str2.length()-1) == str3.charAt(0) &&
				str3.charAt(str3.length()-1) == str1.charAt(0)) {
			System.out.println("good");
		}else System.out.println("bad");
	}
}
