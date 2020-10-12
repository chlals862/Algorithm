package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TwoDots {
	static int R,C,startR,startC;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				startR = row; startC = col;
				visit = new boolean[R][C];
				dfs(row,col,1);
			}
		}
		if(flag) {
			bw.write("Yes");
		}else bw.write("No");
		bw.flush();
		bw.close();
	}
	private static void dfs(int row, int col,int count) {
		visit[row][col] = true;
		int color = map[row][col];
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(!visit[nr][nc] && map[nr][nc] == color) {
					visit[nr][nc] = true;
					dfs(nr,nc,count+1);
				} else if(startR == nr && startC == nc && count >= 4) {
					flag = true;
					return;
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col) - 'A';
			}
		}
	}
}
