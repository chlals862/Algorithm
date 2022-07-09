package CodeUp.정렬;

import java.util.Scanner;

public class _1709 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int row=0;row<arr.length;row++) arr[row] = sc.nextInt();
		
		for(int row=0;row<arr.length-1;row++) {
			for(int col=row+1;col<arr.length;col++) {
				if(arr[row] < arr[col]) {
					int tmp = arr[row];
					arr[row] = arr[col];
					arr[col] = tmp;
				}
			}
		}
		
		for(int row=0;row<arr.length;row++) System.out.print(arr[row]+" ");
	}
}
