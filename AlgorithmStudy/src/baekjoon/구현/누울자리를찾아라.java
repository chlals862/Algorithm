package baekjoon.구현;

import java.util.Scanner;

public class 누울자리를찾아라 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		int resultR = 0;
		int resultC = 0;
		for(int row=0;row<N;row++) {
			String str = sc.next();
			for(int col=0;col<N;col++) {
				map[row][col] = str.charAt(col);
			}
		}
		
		for(int row=0;row<N;row++) {
			int r = 0;
			int c = 0;
			for(int col=0;col<N;col++) {
				
				if(map[row][col] == '.') c++;
				if(map[row][col] == 'X' || (col == N-1)) {
					if(c >= 2) resultC++;
					c = 0;
				}
				if(map[col][row] == '.') r++;
				if(map[col][row] == 'X' || (col == N-1)) {
					if(r >= 2) resultR++;
					r = 0;
				}	
			}
		}	
		System.out.println(resultC + " " + resultR);
	}
}
