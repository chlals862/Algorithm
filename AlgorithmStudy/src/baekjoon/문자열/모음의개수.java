package baekjoon.문자열;

import java.util.Scanner;

public class 모음의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int count = 0;
		for(int row=0;row<str.length();row++) {
			if(str.charAt(row) == 'a' || str.charAt(row) == 'e'
					|| str.charAt(row) == 'i' || str.charAt(row) == 'o' || str.charAt(row) == 'u') {
				count++;
			}
		}
		System.out.println(count);
	}
}
