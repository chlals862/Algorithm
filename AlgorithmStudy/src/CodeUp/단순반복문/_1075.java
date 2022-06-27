package CodeUp.단순반복문;

import java.util.Scanner;

public class _1075 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num  = sc.nextInt();
		num-=1;
		while(num >= 0) {
			System.out.println(num);
			num--;
		}
	}
}
