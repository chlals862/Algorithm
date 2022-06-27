package CodeUp.조건문;

import java.util.Scanner;

public class _1160 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		
		switch(day) {
		case 1 :
		case 3 :
		case 5 :
		case 7 : System.out.println("oh my god");
				 break;
		default : System.out.println("enjoy");
				 break;
		}
	}
}
