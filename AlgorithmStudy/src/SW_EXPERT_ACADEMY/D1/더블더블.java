package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 더블더블 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int a = 1;
		System.out.print("1 ");
		if(num <= 30) {
			for(int i=1; i<=num; i++) {
				System.out.print(2*a + " ");
				a= 2*a;
			}
		}
	}
}
	