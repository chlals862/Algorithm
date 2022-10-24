package baekjoon.구현;

import java.util.Scanner;

public class BOJ2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for(int row=0;row<arr.length;row++) {
			arr[row] = sc.nextInt();
			max = Math.max(max, arr[row]);
		}
		for(int row=0;row<arr.length;row++) {
			if(max == arr[row]) {
				idx = row;
			}
		}
		System.out.println(max);
		System.out.println(idx+1);
	}
}
