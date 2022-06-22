package CodeUp.조건문;

import java.util.Scanner;

public class _1067 {
	static long a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		if(a < 0) {
			System.out.println("minus");
		}else System.out.println("plus");
		
		if(a % 2 != 0) {
			System.out.println("odd");
		}else System.out.println("even");
	}
}
