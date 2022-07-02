package CodeUp.단순반복문;

import java.util.Scanner;

public class _1088 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int row=1;row<=num;row++) {
			
			if(row % 3 != 0) {
				System.out.print(row+" ");
			}
		}
	}
}
