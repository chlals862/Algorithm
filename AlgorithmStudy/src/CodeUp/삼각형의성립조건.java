package CodeUp;

import java.util.Scanner;

public class 삼각형의성립조건 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(c > a && c > b && c < a+b) {
			System.out.println("yes");
		}else System.out.println("no");
	}
}
