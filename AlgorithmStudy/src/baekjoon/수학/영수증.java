package baekjoon.수학;

import java.util.Scanner;

public class 영수증 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int receipt = sc.nextInt();
		int t = sc.nextInt();
		int sum = 0;
		for(int a=0;a<t;a++) {
			int price = sc.nextInt();
			int cnt = sc.nextInt();
			sum += price*cnt;
		}
		
		if(receipt == sum) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
