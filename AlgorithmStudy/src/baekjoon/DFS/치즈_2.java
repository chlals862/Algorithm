package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 치즈_2 {
	static int R,C,time;
	static int[][] map,visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			visit = new int[R][C];
			flag = false;
			dfs(0,0);
			check();
			time++;
			if(!flag) break;
		}
		bw.write(time+"\n");
		bw.flush();
		bw.close();
	}
	private static void check() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] != 0) {
					flag = true;
				}
			}
		}
	}
	private static void dfs(int row, int col) {
		visit[row][col] = 1;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == 0 && visit[nr][nc] == 0) {
					visit[nr][nc] = 1;
					dfs(nr,nc);
				} else if(map[nr][nc] == 1) {
					visit[nr][nc]++;
					if(visit[nr][nc] >= 2) {
						map[nr][nc] = 0;
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}

}
