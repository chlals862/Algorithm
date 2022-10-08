package baekjoon.DP;

import java.util.Scanner;

public class 이xN_타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N+2];
		arr[1] = 1;
		arr[2] = 2;
		for(int row=3;row<=N;row++) {
			arr[row] = arr[row-1] + arr[row-2]%10007; 
		}
		System.out.println(arr[N]%10007);
	}
}
