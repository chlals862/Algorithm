package CodeUp.조건문;

import java.util.Scanner;

public class _1068 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num >= 90) System.out.println("A");
		else if(num >= 70) System.out.println("B");
		else if(num >= 40) System.out.println("C");
		else System.out.println("D");
	}
}
