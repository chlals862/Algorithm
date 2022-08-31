package CodeUp.배열;

import java.util.Arrays;
import java.util.Scanner;

public class _1425 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int studentCnt = sc.nextInt();
		int seatCnt = sc.nextInt();
		
		int[] arr = new int[studentCnt];
		for(int row=0;row<arr.length;row++) {
			arr[row] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		for(int row=1;row<=arr.length;row++) {
			System.out.print(arr[row-1]+ " ");
			
			if(row % seatCnt == 0) {
				System.out.println();
			}
		}
	}
}
