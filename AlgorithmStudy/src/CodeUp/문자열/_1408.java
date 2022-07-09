package CodeUp.문자열;

import java.util.Scanner;

public class _1408 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.nextLine();
		
		for(int row=0;row<str.length();row++) {
			sb.append((char)str.charAt(row)+2-'0');
		}
		System.out.println(sb);

	}
}
