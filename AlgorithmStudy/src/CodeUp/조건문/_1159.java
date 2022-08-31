package CodeUp.조건문;

import java.util.Scanner;

public class _1159 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num >= 50 && num <=70 || num % 6 == 0) System.out.println("win");
		else System.out.println("lose");
	}
}
