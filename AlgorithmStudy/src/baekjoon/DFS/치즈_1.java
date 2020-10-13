package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 치즈_1 {
	static int R,C;
	static int resultCnt,Time,count;
	static int[][] map;
	static boolean[][] visit;
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		resultCnt = 0;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1) {
					resultCnt++;
				}
			}
		}
		while(true) {
			flag = false;
			visit = new boolean[R][C];
			dfs(0,0);
			Time++;
			count = 0;
			checkCheese();
			if(!flag) break;
			resultCnt = count;
		}
		bw.write(Time+"\n");
		bw.write(resultCnt+"");
		bw.flush();
		bw.close();
	}
	private static void checkCheese() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1) {
				flag = true;
				count++;
			}
		}
	}
}
	private static void dfs(int row, int col) {
		visit[row][col] = true;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == 0 && !visit[nr][nc]) {
					dfs(nr,nc);
				}else if(map[nr][nc] == 1 && !visit[nr][nc]) {
					map[nr][nc] = 0;
					visit[nr][nc] = true;
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
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
