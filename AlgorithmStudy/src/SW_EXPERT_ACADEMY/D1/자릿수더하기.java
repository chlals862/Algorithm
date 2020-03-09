package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 자릿수더하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		while(N > 0 && N <10000) {
			sum += N%10;
			N /= 10;
		}
		System.out.println(sum);
		
	}
}