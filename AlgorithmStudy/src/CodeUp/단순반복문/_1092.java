package CodeUp.단순반복문;

import java.util.Scanner;

public class _1092 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		int result = 1;
		while(num1 != 0 && num2 != 0 && num3 != 0) {
			result++;
			if(result % num1 == 0 && result % num2 == 0 && result % num3 == 0) {
				break;
			}
		
		}
		System.out.println(result);
	}
}
