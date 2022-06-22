package CodeUp.단순반복문;

import java.util.Scanner;

public class _1081 {
	static int a,b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		
		for(int row=1;row<=a;row++) {
			for(int col=1;col<=b;col++) {
				System.out.println(row + " " + col);
			}
		}
	}
}
