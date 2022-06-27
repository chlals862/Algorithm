package CodeUp.배열;

import java.util.Scanner;

public class _1405 {
	static int num;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		arr = new int[num];
		
		for(int i=0;i<arr.length;i++) arr[i] = sc.nextInt();
		
		for(int row=0;row<arr.length;row++) {
			for(int col=row;col<arr.length;col++) {
				System.out.print(arr[col] + " ");
			}
			for(int col=0;col<row;col++) {
				System.out.print(arr[col] + " ");
			}
			System.out.println();
		}
	}
}
