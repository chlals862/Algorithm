package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2563_ing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken());
			for(int row=left;row<left+10;row++) {
				for(int col=bottom;col<bottom+10;col++) {
					map[row][col] = 1;
				}
			}
		}
		int minus = 0;
		for(int row=0;row<map.length;row++) {
			for(int col=0;col<map.length;col++) {
				if(map[row][col] == 1) {
					minus++;
				}
			}
		}
		bw.write(minus+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
