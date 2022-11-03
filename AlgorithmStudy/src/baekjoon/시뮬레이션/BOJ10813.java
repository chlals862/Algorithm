package baekjoon.시뮬레이션;

import java.util.Scanner;

public class BOJ10813 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] basket = new int[N+1];
		for(int i=1;i<basket.length;i++) {
			basket[i] = i;
		}
		while(M --> 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int temp = 0;
			temp = basket[A];
			basket[A] = basket[B];
			basket[B] = temp;
		}
		for(int i=1;i<basket.length;i++) {
			System.out.print(basket[i] + " ");
		}
	}
}
