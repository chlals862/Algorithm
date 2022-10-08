package baekjoon.DP;

import java.util.Scanner;

public class 수열 {
	static int k = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int min = 1;
		int max = 1;
		for(int row=0;row<N;row++) {
			num[row] = sc.nextInt();
		}
		if(N == 1) {
			System.out.println(1);
		} else {
			for(int row=0;row<N-1;row++) {
				//다음것보다 크거나 같으면 max 증가
				if(num[row] >= num[row+1]) {
					max++;
				} else {
					//초기화
					max = 1;
				}
				k = Math.max(k, max);
			}
			
			
			for(int row=0;row<N-1;row++) {
				//다음것보다 작거나 같으면 min 증가
				if(num[row] <= num[row+1]) {
					min++;
				} else {
					//초기화
					min = 1;
				}
				k = Math.max(k, min);
			}
			
			
			System.out.println(k);
		}
	}
}
