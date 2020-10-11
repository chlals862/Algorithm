package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OilDeposits {
	static int R, C,cnt;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visit = new boolean[R][C];
			list = new ArrayList<Integer>();
			for (int row = 0; row < R; row++) {
				String str = br.readLine();
				for (int col = 0; col < C; col++) {
					map[row][col] = str.charAt(col);
				}
			}	
			logic();
			bw.write(list.size()+"\n");
			if (R == 0 && C == 0)
				return;
			bw.flush();
		}
	}
	private static void logic() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '@' && !visit[row][col]) {
					cnt = 1;
					dfs(row,col);
					list.add(cnt);
				}
			}
		}
	}
	private static void dfs(int row, int col) {
		visit[row][col] = true;
		for(int dir=0;dir<8;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == '@' && !visit[nr][nc]) {
					dfs(nr,nc);
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
