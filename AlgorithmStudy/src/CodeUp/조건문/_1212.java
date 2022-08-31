package CodeUp.조건문;

import java.util.Scanner;

public class _1212 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//a,b,c가 각각 클때
		if(a==b && a == c && b == c) {
			System.out.println("yes");
		}
		
		if(a > b && a > c) {
			if(a < b + c) {
				System.out.println("yes");
			} else System.out.println("no");
		}else if(b > c && b > a) {
			if(b < a + c) {
				System.out.println("yes");
			} else System.out.println("no");
		}else if(c > a && c > b) {
			if(c < a + b) {
				System.out.println("yes");
			} else System.out.println("no");
		}
		
	}
}
