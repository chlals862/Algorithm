package baekjoon.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10817 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		
		for(int row=0;row<arr.length;row++) {
			arr[row] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[1]);
	}
}
