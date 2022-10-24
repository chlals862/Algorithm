package baekjoon.수학;

import java.util.Scanner;

public class BOJ2475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		int gum = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
			gum+= arr[i]*arr[i];
		}
		System.out.println(gum%10);
		
	}
}
