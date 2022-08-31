package SW_EXPERT_ACADEMY.D3;

import java.util.Scanner;

public class 구구단2 {
	static int test;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		test = sc.nextInt();
		for(int t=1;t<=test;t++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
		
			if(num1 >= 10 || num2 >= 10) {
				System.out.println("#"+t+" -1");
			}else System.out.println("#"+t+" "+ num1 * num2);
		}
	}
}
