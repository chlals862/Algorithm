package baekjoon.DP;

import java.util.Scanner;

public class Generations_of_Tribbles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] arr = new long[69];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			for(int row=4;row<=67;row++) {
				arr[row] = arr[row-1] + arr[row-2] + arr[row-3] + arr[row-4];
			}
			System.out.println(arr[n]);
		}
	}
}
