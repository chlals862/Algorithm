package CodeUp.문자열;

import java.util.Scanner;

public class _1418 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		for(int row=0;row<s.length();row++) {
			if(s.charAt(row) == 't') {
				System.out.print(row+1 + " ");
			}
		}
	}
}
