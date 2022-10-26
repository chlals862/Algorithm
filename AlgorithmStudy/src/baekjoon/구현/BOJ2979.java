package baekjoon.구현;

import java.util.Scanner;

public class BOJ2979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[101];
		int sum = 0;
		for(int t=1;t<=3;t++) {
			int startR = sc.nextInt();
			int endR = sc.nextInt()-1;

			for(int i=startR;i<=endR;i++) {
				arr[i]++;
				
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 1) {
				sum += A;
			}else if(arr[i] == 2) {
				sum += B*2;
			}else if(arr[i] == 3) {
				sum += C*3;
			}
		}
		System.out.println(sum);
		
	}
}
