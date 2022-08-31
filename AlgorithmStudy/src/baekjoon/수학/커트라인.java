package baekjoon.수학;

import java.util.Arrays;
import java.util.Scanner;

public class 커트라인 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		for(int row=0;row<arr.length;row++) {
			arr[row] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		System.out.println(arr[arr.length-K]);
	}
}
