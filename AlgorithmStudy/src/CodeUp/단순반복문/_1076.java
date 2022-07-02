package CodeUp.단순반복문;

import java.util.Scanner;

public class _1076 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char input = sc.nextLine().charAt(0);
		for(char row='a';row<=input;row++) {
			System.out.println(row);
		}
	}
}
