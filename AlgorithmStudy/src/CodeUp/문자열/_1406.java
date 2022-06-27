package CodeUp.문자열;

import java.util.Scanner;

public class _1406 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		StringBuilder sb = new StringBuilder();
		if(s.equals("love")) {
			sb.append("I love you.");
		}
		System.out.println(sb);
	}
}
