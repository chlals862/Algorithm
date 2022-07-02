package CodeUp.배열;

import java.util.Scanner;

public class _1409 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int row=0;row<arr.length;row++) {
			arr[row] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(arr[target-1]);
		
		
	}
}
