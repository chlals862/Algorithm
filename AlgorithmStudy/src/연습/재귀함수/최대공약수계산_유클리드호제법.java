package 연습.재귀함수;

import java.util.Scanner;

public class 최대공약수계산_유클리드호제법 {
	static int a,b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		gcd(a,b);
		System.out.println(gcd(a,b));
	}
	private static int gcd(int a, int b) {
		if(a%b == 0) {
			return b;
		}else return gcd(b, a%b);
	}
}
