package CodeUp.조건문;

import java.util.Scanner;

public class _1066 {
	static long a,b,c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		b = sc.nextLong();
		c = sc.nextLong();
		
		if(a % 2 != 0) {
			System.out.println("odd");
		}else System.out.println("even");
		
		if(b % 2 != 0) {
			System.out.println("odd");
		}else System.out.println("even");
		
		if(c % 2 != 0) {
			System.out.println("odd");
		}else System.out.println("even");
	}
}
