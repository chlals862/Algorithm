package CodeUp.단순반복문;

import java.util.Scanner;

public class _1091 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int mul = sc.nextInt();
		int add = sc.nextInt();
		int k = sc.nextInt();
		//1 -2 1 1
		Long result = (long) (num1*(mul)+add);
		//System.out.println(result);
		for(int i=0;i<k-2;i++) {
			result = (long) (result*(mul)+add);
		}
		if(k > 1) {
			System.out.println(result);
		}else if(k == 1) {
			System.out.println(num1);
		}
	}
}
