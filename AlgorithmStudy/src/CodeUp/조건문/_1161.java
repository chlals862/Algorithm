package CodeUp.조건문;

import java.util.Scanner;

public class _1161 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		if(num1 % 2 == 0) {
			sb.append("짝수+");
		}else sb.append("홀수+");
		
		if(num2 % 2 == 0) {
			sb.append("짝수");
		}else sb.append("홀수");
		
		if((num1+num2) %2 == 0) sb.append("=짝수");
		else sb.append("=홀수");
		
		System.out.println(sb);
	}
}
