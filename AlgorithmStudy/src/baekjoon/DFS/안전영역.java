package baekjoon.DFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 안전영역 {
	static int N,maxHeight,maxArea;
	static int[][] area;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(area[row][col] > maxHeight) {
					maxHeight = area[row][col];
				}
			}
		}
		rain();
		bw.write(maxArea+"");
		bw.flush();
		bw.close();
	}
	private static void rain() {
		for(int rain=0;rain<maxHeight;rain++) {
			dfsAll(rain);
		}
	}
	private static void dfsAll(int rain) {
		visit = new boolean[N][N];
		int result = 0;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(area[row][col] > rain && !visit[row][col] ) {
					result++;
					dfs(row,col,rain);
				}
			}
		}
		maxArea = Math.max(result, maxArea);
	}
	private static void dfs(int cr, int cc, int rain) {
		visit[cr][cc] = true;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(area[nr][nc] > rain && !visit[nr][nc]) {
					visit[nr][nc] = true;
					dfs(nr,nc,rain);
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N ) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		area = new int[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				area[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
