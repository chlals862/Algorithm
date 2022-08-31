package CodeUp.조건문;

import java.util.Scanner;

public class _1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float num = sc.nextFloat();
		
		if(num >= 50 && num <= 60) System.out.println("win");
		else System.out.println("lose");
	}
}
