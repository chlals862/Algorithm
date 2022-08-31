package CodeUp.조건문;

import java.util.Scanner;

public class _1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if((num >= 30 && num <= 40) || (num >= 60 && num <= 70)) System.out.println("win");
		else System.out.println("lose");
	}
}
