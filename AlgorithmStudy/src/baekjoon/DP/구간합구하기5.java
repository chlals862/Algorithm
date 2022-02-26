package baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구간합구하기5 {
	static int N,M,x1,y1,x2,y2;
	static int[][] map;
	static int[][] dp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int row=1;row<=N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=1;col<=N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		 * dp[row][col] -> dp[1][1]부터 dp[row][col]까지 합을 저장해 놓는 배열 -> [1][1] , [row][col]로 만들어지는 사각형
		 * dp[row][col] -> dp[row-1][col]값과 dp[row][col-1]을 더하고 겹치는 부분인 dp[row-1][col-1]을 빼줌
		 * */
		for(int row=1;row<=N;row++) {
			for(int col=1;col<=N;col++) {
				dp[row][col] = dp[row-1][col] + dp[row][col-1] - dp[row-1][col-1] + map[row][col];
			}
		}
		
//		System.out.println();
//		for(int row=1;row<=N;row++) {
//			for(int col=1;col<=N;col++) {
//				System.out.print(dp[row][col]+ " ");
//			}
//			System.out.println();
//		}
		for(int i=0;i<M;i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			sum += dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
			bw.write(sum+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
