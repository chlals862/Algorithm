package baekjoon.문자열;

import java.util.Scanner;

public class 그릇 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int height = 10;
		
		for(int row=1;row<str.length();row++) {
			if(str.charAt(row) == str.charAt(row-1)) {
				height += 5;
			}else {
				height += 10;
			}
		}
		System.out.println(height);
	}
}
