package baekjoon.수학;

import java.util.Scanner;

public class 영수증_수학 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = sc.nextInt();
		
		for(int row=9;row>0;row--) {
			sum -= sc.nextInt();
		}
		System.out.println(sum);
	}
}
