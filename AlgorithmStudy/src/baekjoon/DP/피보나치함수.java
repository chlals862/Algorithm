package baekjoon.DP;

import java.util.Scanner;

public class 피보나치함수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int row=0;row<N;row++) {
			int size = sc.nextInt();
				if(size > 0) {
					int[] fibo = new int[size+1];
					fibo[1] = 1;
					
					for(int i=2;i<fibo.length;i++) {
						fibo[i] = fibo[i-2] + fibo[i-1];
					}
				System.out.println(fibo[size-1] + " " + fibo[size]);
		}else if(size == 0) {
			System.out.println("1 0");
		}
	}
		
		
		
	}
}
