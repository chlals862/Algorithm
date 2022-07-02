package CodeUp.배열;

import java.util.Scanner;

public class _1093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[23];
		
		
		for(int row=0;row<num;row++) {
			int number = sc.nextInt();
			arr[number-1]++;
		}
		
		for(int row=0;row<arr.length;row++) {
			System.out.print(arr[row]+ " ");
		}
	}
}
