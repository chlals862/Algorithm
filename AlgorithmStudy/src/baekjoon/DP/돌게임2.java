package baekjoon.DP;

import java.util.Scanner;

public class 돌게임2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		if(N % 2 == 0) {
			System.out.println("SK");
		} else System.out.println("CY");
	}
}
