package CodeUp.문자열;

import java.util.Scanner;

public class _1024 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		for(int row=0;row<str.length();row++) {
			System.out.println("'"+str.charAt(row)+"'");
		}
	}
}
