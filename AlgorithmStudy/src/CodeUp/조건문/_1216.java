package CodeUp.조건문;

import java.util.Scanner;

public class _1216 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		int yes = sc.nextInt();
		int price = sc.nextInt();
		
		if(yes-price > no) {
			System.out.println("advertise");
		}else if(yes-price < no	) {
			System.out.println("do not advertise");
		}else System.out.println("does not matter");
	}
}
