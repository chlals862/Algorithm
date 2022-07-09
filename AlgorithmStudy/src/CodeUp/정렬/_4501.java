package CodeUp.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class _4501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		
		for(int row=0;row<arr.length;row++) arr[row] = sc.nextInt();
		Arrays.sort(arr);
		
		System.out.println(arr[arr.length-1]);
		System.out.println(arr[arr.length-2]);
	}
}
