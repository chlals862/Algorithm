package baekjoon.수학;

import java.util.Scanner;

public class 행렬덧셈 {
	static int R;
	static int C;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		int[][] arr = new int[R][C];
		int[][] arr2 = new int[R][C];
		
		newArray(arr);
		newArray(arr2);
		
		result(arr,arr2);
	}

	

	private static void result(int[][] arr, int[][] arr2) {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(arr[row][col] + arr2[row][col]+ " ");
			}
			System.out.println();
		}
	}
	private static void newArray(int[][] arr) {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				arr[row][col] = sc.nextInt();
			}
		}
		
	}
}
