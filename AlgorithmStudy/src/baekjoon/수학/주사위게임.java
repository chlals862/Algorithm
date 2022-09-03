package baekjoon.수학;

import java.util.Scanner;

public class 주사위게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int chang = 100;
		int jung = 100;
		
		int k = sc.nextInt();
		while(k --> 0) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			if(num1 < num2) {
				jung -= num2;
			}else if(num1 > num2) {
				chang -= num1;
			}
		}
		System.out.println(jung);
		System.out.println(chang);
	}
}
