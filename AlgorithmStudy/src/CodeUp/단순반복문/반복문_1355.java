package CodeUp.단순반복문;

import java.util.Scanner;

public class 반복문_1355 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int row=0;row<n;row++) {
			for(int col=0;col<row;col++) {
				System.out.print(" ");
			}
			for(int col=n;col>row;col--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
