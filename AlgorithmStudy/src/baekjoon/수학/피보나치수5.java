package baekjoon.수학;

import java.util.Scanner;

public class 피보나치수5 {
	static int result(int num) {
	if(num == 0) {
		return 0;
	}
	else if(num == 1) {
			return 1;
		} else if(num == 2) {
			return 1;
		} else {
			return result(num-1) + result(num-2);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(result(input));
	}
}
