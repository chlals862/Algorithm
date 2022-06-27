package CodeUp.문자열;

import java.util.Scanner;

public class _1410 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int num1 = 0;
		int num2 = 0;
		
		for(int row=0;row<s.length();row++) {
			if(s.charAt(row) == '(') {
				num1++;
			}else if(s.charAt(row) == ')') {
				num2++;
			}
		}
		System.out.println(num1 + " " + num2);
	}
}
