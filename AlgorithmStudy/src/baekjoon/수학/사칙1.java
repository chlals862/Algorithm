package baekjoon.수학;

import java.util.Scanner;

public class 사칙1 {

	static int a;
	static int b;
	static int sum;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int inputNum = sc.nextInt();
		
		
		for(int i=0;i<inputNum;i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			sum = a+b;
			System.out.println(sum);
		}
	}
}
