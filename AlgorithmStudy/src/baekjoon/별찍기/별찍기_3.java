package baekjoon.별찍기;

import java.util.Scanner;

public class 별찍기_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (1 <= N && N <= 100) {

			for (int i = 0; i < N; i++) {
				for (int j = N; j > i; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
