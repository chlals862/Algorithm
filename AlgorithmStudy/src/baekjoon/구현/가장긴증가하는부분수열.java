package baekjoon.구현;

import java.util.Scanner;

public class 가장긴증가하는부분수열 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[] arr = new int[N];
		int[] temp = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		temp[0] = 1;
		
		for(int i=1;i<N;i++) {
			temp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i] && temp[i] <= temp[j]) {
					temp[i] = temp[j] + 1;
				}
			}
		}
		int result = 0;
		for(int i=0;i<N;i++) {
			result = Math.max(temp[i], result);
		}
		System.out.println(result);
	}
}
