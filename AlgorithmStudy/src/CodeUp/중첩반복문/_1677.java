package CodeUp.중첩반복문;

import java.util.Scanner;

public class _1677 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		String[][] map = new String[R][C];
		
		
		
		
		
			for(int row=0;row<R;row++) {
				map[row][0] = "|";
				map[row][C-1] = "|";
			}
		
		
			for(int col=0;col<C;col++) {
				map[0][col] = "-";
				map[R-1][col] = "-";
			}
			
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(map[row][col] == null) {
						map[row][col] = " ";
					}
				}
			}
			
			map[0][0] = "+";
			map[0][C-1] = "+";
			map[R-1][0] = "+";
			map[R-1][C-1] = "+";
			
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col] + "");
			}
			System.out.println();
		}
		
	}
}
