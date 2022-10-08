package baekjoon.DP;

import java.util.Scanner;

public class BABBA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		int[] num = new int[K+1];
		num[1] = 1;
		
		for(int i=2;i<num.length;i++) {
			num[i] = num[i-2] + num[i-1];
		}
		System.out.println(num[K-1] + " " + num[K]);
	}
}
