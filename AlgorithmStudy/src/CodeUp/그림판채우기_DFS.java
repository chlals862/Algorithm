package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 그림판채우기_DFS {
	static int startR,startC;
	static char[][] map;
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
		if(visit[startC][startR] && map[startC][startR] == '*') {
			check(startC,startR);
			printMap();
			return;
		}
		else if(!visit[startC][startR] && map[startC][startR] == '_') {
			map[startC][startR] = '*';
			dfs(startC,startR);
		}
		printMap();
		bw.flush();
		bw.close();
	}
	private static void dfs(int cr, int cc) {
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == '_' && !visit[nr][nc]) {
					visit[nr][nc] = true;
					map[nr][nc] = '*';
					dfs(nr,nc);
				}
			}
		}
	}
	private static void check(int cr,int cc) {
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == '_' && !visit[nr][nc]) {
					map[nr][nc] = '*';
					visit[nr][nc] = true;
					check(nr,nc);
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < 10 && nc >= 0 && nc < 10) return true;
			return false;
	}
	private static void setData() throws IOException {
		map = new char[10][10];
		visit = new boolean[10][10];
		for(int row=0;row<10;row++) {
			String str = br.readLine();
			for(int col=0;col<10;col++) {
				map[row][col] = str.charAt(col);
			}
		}
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
	}
	private static void printMap() throws IOException {
		for(int row=0;row<10;row++) {
			for(int col=0;col<10;col++) {
				bw.write(map[row][col]+"");
			}
			bw.write("\n");
		}
	}
}
