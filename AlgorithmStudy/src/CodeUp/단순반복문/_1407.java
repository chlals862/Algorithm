package CodeUp.단순반복문;

import java.util.Scanner;

public class _1407 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		for(int row=0;row<s.length();row++) {
			if(s.charAt(row) != ' ') {
				System.out.print(s.charAt(row));
			}
		}
	}
}
