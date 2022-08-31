package CodeUp.조건문;

import java.util.Scanner;

public class _1226 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] lotto = new int[7];
		for(int row=0;row<lotto.length;row++) lotto[row] = sc.nextInt();
		boolean[] flag = new boolean[7];
		int count = 0;
		for(int row=0;row<6;row++) {
			int num = sc.nextInt();
			for(int col=0;col<lotto.length;col++) {
				if(num == lotto[col] && !flag[col]) {
					flag[col] = true;
					count++;
					break;
				}
				
			}
		}

	if(!flag[flag.length-1]) {
		if(count <= 2) {
			System.out.println("0");
		}else if(count == 3 ) {
			System.out.println("5");
		}else if(count == 4) {
			System.out.println("4");
		}else if(count == 5) {
			System.out.println("3");
		}else if(count == 6) {
			System.out.println("1");
		}
		
		}else if(flag[flag.length-1]) {
			if(count <= 2) {
				System.out.println("0");
			}else if(count == 3 ) {
				System.out.println("0");
			}else if(count == 4) {
				System.out.println("5");
			}
			else if(count == 5) {
				System.out.println("4");
			}else if(count == 6) {
				System.out.println("2");
			}
		}
	}
}
