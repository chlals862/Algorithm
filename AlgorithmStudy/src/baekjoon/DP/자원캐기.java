package baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 자원캐기 {
	static int R,C;
	static int[][] map,dp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R+1][C+1];
		dp = new int[R+1][C+1];
		
		for(int row=1;row<=R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=1;col<=C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int row=1;row<=R;row++) {
			for(int col=1;col<=C;col++) {
				dp[row][col] = Math.max(dp[row-1][col],dp[row][col-1])+map[row][col];
			}
		}
		
		bw.write(dp[R][C]+"");
		bw.flush();
		bw.close();
		/*
		for(int row=1;row<=R;row++) {
			for(int col=1;col<=C;col++) {
				System.out.print(dp[row][col]+" ");
			}
			System.out.println();
		}
		*/
		
	}

}
