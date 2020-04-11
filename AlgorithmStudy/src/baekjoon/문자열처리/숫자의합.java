package baekjoon.문자열처리;

import java.util.Scanner;

//N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
public class 숫자의합 {
	
	static int sum = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		String s = sc.next();
		//int num[] = new int[input];
		
		for(int i=0;i<input;i++) {
			sum += s.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
