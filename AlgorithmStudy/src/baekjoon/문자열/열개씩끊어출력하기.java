package baekjoon.문자열;

import java.util.Scanner;

public class 열개씩끊어출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		for(int row=0;row<str.length();row++) {
			System.out.print(str.charAt(row));
			if(row % 10 == 9) {
				System.out.println();
			}
		}
	}
}
