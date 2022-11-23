package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10709 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];
		int[][] result = new int[H][W];
		
		for(int row=0;row<H;row++) {
			String str = br.readLine();
			for(int col=0;col<W;col++) {
				map[row][col] = str.charAt(col);
			}
		}
		
		for(int row=0;row<H;row++) {
			int cnt = 1;
			boolean flag = false;
			for(int col=0;col<W;col++) {
				if(map[row][col] == '.' && !flag) {
					result[row][col] = -1;
				}
				if(map[row][col] == 'c') {
					result[row][col] = 0;
					flag = true;
				}
				if(map[row][col] == '.' && flag) {
					result[row][col] = cnt++;
				}
				if(map[row][col] == 'c' && flag) {
					cnt = 1;
				}
			}
		}
		
		for(int row=0;row<H;row++) {
			for(int col=0;col<W;col++) {
				bw.write(result[row][col] + " ");
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
