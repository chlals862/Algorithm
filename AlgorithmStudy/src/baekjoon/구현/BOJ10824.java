package baekjoon.구현;

import java.util.Scanner;

public class BOJ10824 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		String C = sc.next();
		String D = sc.next();
		
		System.out.println(Long.parseLong(A+B) + Long.parseLong(C+D));
		
	}

}
