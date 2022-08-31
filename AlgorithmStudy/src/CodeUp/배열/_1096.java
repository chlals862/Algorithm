package CodeUp.배열;

import java.util.Scanner;

public class _1096 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[19][19];
		
		int N = sc.nextInt();

		while(N --> 0) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			
			for(int row=0;row<19;row++) {
				for(int col=0;col<19;col++) {
					map[R-1][C-1] = 1;
				}
			}
		}
		for(int row=0;row<19;row++) {
			for(int col=0;col<19;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
	}
}
