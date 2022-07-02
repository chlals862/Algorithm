package CodeUp.단순반복문;

import java.util.Scanner;

public class _1089 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int value = sc.nextInt();
		int k = sc.nextInt();
		
		int sum = start;
		for(int row=1;row<k;row++) {
			sum += value;
		}
		System.out.println(sum);
		
	}
}
