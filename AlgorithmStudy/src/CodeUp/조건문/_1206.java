package CodeUp.조건문;

import java.util.Scanner;

public class _1206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int ab = a/b;
		int ba = b/a;
		if((a * ba) == b) {
			System.out.print(a+"*"+ba+"="+b);
		}
		else if((b * ab) == a) {
			System.out.print(b+"*"+ab+"="+a);	
		}else System.out.println("none");
	}
}
