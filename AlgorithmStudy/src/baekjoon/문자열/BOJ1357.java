package baekjoon.문자열;

import java.util.Scanner;

public class BOJ1357 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String X = sc.next();
		String Y = sc.next();
		
		StringBuilder sbX = new StringBuilder();
		
		sbX.append(X).reverse();
		StringBuilder sbY = new StringBuilder();
		sbY.append(Y).reverse();
		//int result = Integer.parseInt(sbX.append(X).reverse().toString()) +
		//	Integer.parseInt(sbY.append(Y).reverse().toString());


		int result = Integer.parseInt(sbX.toString()) + Integer.parseInt(sbY.toString());
		//System.out.println(result); -> 123 100 -> 321 + 001 -> 322
		StringBuilder sbZ = new StringBuilder();
		//01 방지 -> 문자열 -> 숫자
		System.out.println(Integer.parseInt(sbZ.append(result).reverse().toString()));
		
	}	
}
