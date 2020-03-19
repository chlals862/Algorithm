package baekjoon.별찍기;

import java.util.Scanner;

/*
	 * 첫째 줄에는 별 1개, 둘쨰 줄에는 별2개.... N번쨰 줄에는 별N개를 찍는 문제
	 * */
public class 별찍기_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (1 <= N && N <= 100) {
			
			for (int i = 0; i < N; i++) {
				for(int j = 0; j<i+1;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}
