package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 치즈 {
	static int R,C,resultCnt,cnt,time;
	static int[][] map;
	static boolean[][] visit;
	static boolean flag;
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
		check();
		while(true) {
			flag = false;
			visit = new boolean[R][C];
			dfs(0,0);
			cnt = 0;
			time++;
			check2();
			if(!flag) break;
			resultCnt = cnt;
		}
		bw.write(time+"\n");
		bw.write(resultCnt+"");
		bw.flush();
		bw.close();
	}
	private static void check2() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1) {
					flag = true;
					cnt++;
				}
			}
		}
	}
	private static void check() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1) {
					resultCnt++;
				}
			}
		}
	}
	//1 -> 치즈 , 0 -> 빈 곳
	private static void dfs(int cr, int cc) {
		visit[cr][cc] = true;
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == 0 && !visit[nr][nc]) {
					dfs(nr,nc);
				}
				else if(map[nr][nc] == 1 && !visit[nr][nc]) {
					visit[nr][nc] = true;
					map[nr][nc] = 0;
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C )return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
