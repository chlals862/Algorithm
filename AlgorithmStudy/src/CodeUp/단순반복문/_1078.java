package CodeUp.단순반복문;

import java.util.Scanner;

public class _1078 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		for(int row=0;row<=num;row++) {
			if(row %2 == 0) {
				sum+=row;
			}
		}
		System.out.println(sum);
	}
}
