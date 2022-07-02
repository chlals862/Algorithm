package CodeUp.단순반복문;

import java.util.Scanner;

public class _1079 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] str = sc.nextLine().split(" ");
		
		for(int row=0;row<str.length;row++) {
			System.out.println(str[row]);
			if(str[row].equals("q")) {
				break;
			}
		}
	}
}
