package CodeUp.조건문;

import java.util.Arrays;
import java.util.Scanner;

public class _1154 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[2];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		Arrays.sort(arr);
		System.out.println(arr[1] - arr[0]);
	}
}
