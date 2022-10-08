package baekjoon.DP;

import java.util.Scanner;

public class 부녀회장이될테야 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int K = sc.nextInt();
			int N = sc.nextInt();
			int[][] arr = new int[15][15];
			for(int floor=0;floor<15;floor++) {
				arr[0][floor] = floor;
				arr[floor][1] = 1;
			}
			
			for(int floor=1;floor<15;floor++) {
				for(int number=2;number<15;number++) {
					arr[floor][number] = arr[floor][number-1] + arr[floor-1][number];
				}
			}
			System.out.println(arr[K][N]);
		}
	}
}
