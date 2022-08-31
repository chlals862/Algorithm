package CodeUp.정렬;

import java.util.Scanner;

public class _1451 {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		
		for(int row=0;row<arr.length;row++) {
			arr[row] = sc.nextInt();
		}
		
		for(int row=0;row<arr.length-1;row++) {
			for(int col=row;col<arr.length;col++) {
				if(arr[row] > arr[col]) {
					int tmp = arr[col];
					arr[col] = arr[row];
					arr[row] = tmp;
				}
			}
		}
		
		for(int row=0;row<arr.length;row++) {
			System.out.println(arr[row]);
		}
		
		
	}
}
