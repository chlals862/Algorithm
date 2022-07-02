package CodeUp.중첩반복문;

import java.util.Scanner;

public class _1380 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int row=1;row<=6;row++) {
			for(int col=6;col>=1;col--) {
				if(row+col == num) {
					System.out.println(row + " " + col);
				}
			}
		}
	}
}
