package CodeUp.중첩반복문;

import java.util.Scanner;

public class _1351 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		for(int row=start;row<=end;row++) {
			for(int col=1;col<=9;col++) {
				System.out.println(row+"*"+col+"="+row*col);
			}
		}
	}
}
