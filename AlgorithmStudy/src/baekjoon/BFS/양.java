package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 양 {
	static int R,C,wolf,sheep;
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
		int resultSheep = 0;
		int resultWolf = 0;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
					sheep = 0;
					wolf = 0;
					bfs(row,col);
				if(sheep > wolf) resultSheep += sheep;
				else resultWolf += wolf;
			}
		}
		bw.write(resultSheep + " " + resultWolf);
		bw.flush();
		bw.close();
	}
	private static void bfs(int cr,int cc) {
		if(map[cr][cc] != '#' && !visit[cr][cc]) {
			visit[cr][cc] = true;
			if(map[cr][cc] == 'v') wolf++;
			else if(map[cr][cc] == 'o') sheep++;
			for(int dir=0;dir<4;dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if(rangeCheck(nr,nc)) {
					bfs(nr,nc);
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
		map = new char[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col);
			}
		}
	}
}
