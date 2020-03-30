package SW_EXPERT_ACADEMY.D2;

import java.util.Scanner;

public class 거스름돈 {

	public static void main(String[] args) {
		
		final int money[] = {50000,10000,5000,1000,500,100,50,10};
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			System.out.format("#%d \n",i+1);
			
			for(int j : money) {
				System.out.format("%d ", n/j);
				n %= j;
			}
			System.out.format("\n");
		}//for
	}
}
