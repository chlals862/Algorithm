package baekjoon.누적합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class BOJ16507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[R+1][C+1];
		
		
		for(int row=1;row<=R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=1;col<=C;col++) {
				map[row][col] = map[row-1][col] + map[row][col-1] - map[row-1][col-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		while(K -- > 0) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			int cnt = ((endR-startR)+1) * ((endC-startC)+1);
			
			bw.write((map[endR][endC] - map[startR-1][endC] - map[endR][startC-1] + map[startR-1][startC-1]) / cnt+"\n");
		}
		//이해불가
		br.close();
		bw.flush();
		bw.close();
	}
}
