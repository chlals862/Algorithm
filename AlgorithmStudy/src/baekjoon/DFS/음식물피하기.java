package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 음식물피하기 {
	static int R,C,K,cnt;
	static int max = Integer.MIN_VALUE;
	static int startR,startC;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1 && !visit[row][col]) {
					cnt = 1;
					dfs(row,col);
					max = (Math.max(max, cnt) == max ) ? max : cnt;
				}
			}
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int row, int col) {
		visit[row][col] = true;
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == 1 && !visit[nr][nc]) {
					dfs(nr,nc);
					cnt++;
				}
			}
		}
		
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken())-1;
			startC = Integer.parseInt(st.nextToken())-1;
			map[startR][startC] = 1; 
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >=0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
