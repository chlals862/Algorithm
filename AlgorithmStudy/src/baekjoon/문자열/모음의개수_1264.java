package baekjoon.문자열;

import java.util.Scanner;

public class 모음의개수_1264 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			if(str.equals("#")) break;
			int cnt = 0;
			
			str = str.toLowerCase();
			
			for(int row=0;row<str.length();row++) {
				if(str.charAt(row) == 'a' || str.charAt(row) == 'e' ||
				   str.charAt(row) == 'i' || str.charAt(row) == 'o' ||
				   str.charAt(row) == 'u') {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
