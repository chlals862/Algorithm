package baekjoon.DP;

import java.util.Scanner;

public class 이동하기 {

	static int R,C;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) {

		inputData();
	}

	private static void inputData() {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		map = new int[R+1][C+1];
		for(int row=1;row<=R;row++) {
			for(int col=1;col<=C;col++) {
				map[row][col] = sc.nextInt();
			}
		}
		//view();
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				map[i][j] += Math.max(map[i][j-1],Math.max(map[i-1][j],map[i-1][j-1]));
			}
		}
		System.out.println(map[R][C]);
		
	}

	private static void view() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	
}
