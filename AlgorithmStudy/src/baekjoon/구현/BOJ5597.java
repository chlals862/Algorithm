package baekjoon.구현;

import java.util.Scanner;

public class BOJ5597 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[31];
		
		for(int row=1;row<29;row++) {
			int input = sc.nextInt();
			arr[input] = 1;
		}
		for(int row=1;row<arr.length;row++) {
			if(arr[row] != 1) {
				System.out.println(row);
			}
		}
	}
}
