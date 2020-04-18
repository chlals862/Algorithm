package baekjoon.수학;

import java.util.Scanner;

public class 파보나치수2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		long[] num = new long[input+1];
		num[1]=1;
		for(int i=2;i<num.length;i++) {
			
			num[i] = num[i-1] + num[i-2];
			
		}
		System.out.println(num[input]);
	}
}
