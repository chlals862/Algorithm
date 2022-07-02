package CodeUp.중첩반복문;

import java.util.Scanner;

public class _1378 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int result = 0;
		for(int row=1;row<=num;row++) {
			for(int col=1;col<row;col++) {
				result+=col;
			}
			result+=row;
		}
		System.out.println(result);
	}
}
