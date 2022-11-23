package baekjoon.구현;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
/*
1
5 4
1 0 0 0
0 0 1 0
1 0 0 1
0 1 0 0
1 0 1 0
 * */
public class BOJ9455 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T --> 0) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int sum = 0;
			int[][] map = new int[R][C];
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					map[row][col] = sc.nextInt();
				}
			}

			for(int col=0;col<C;col++) {
				for(int row=0;row<R-1;row++) {
					if(map[row][col] == 1 && map[row+1][col] == 0) {
						int temp = map[row][col];
						map[row][col] = map[row+1][col];
						map[row+1][col] = temp;
						sum++;
						row = -1;
					}
					
				}
			}

			bw.write(sum+"\n");
		}//while
		bw.flush();
		bw.close();
	}
}
