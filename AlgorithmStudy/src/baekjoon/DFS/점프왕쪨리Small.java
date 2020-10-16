package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 점프왕쪨리Small {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		dfs(0,0);
		if(flag) {
			bw.write("HaruHaru");
		}else bw.write("Hing");
		bw.flush();
		bw.close();
	}
	private static void dfs(int cr, int cc) {
		visit[cr][cc] = true;
		int jump = map[cr][cc];
		int[] dr = {0,0,1,0};
		int[] dc = {0,1,0,0};
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir] * jump;
			int nc = cc + dc[dir] * jump;
			if(rangeCheck(nr,nc)) {
				if(nr == N-1 && nc == N-1) {
					flag = true;
					return;
				}
				if(!visit[nr][nc]) {
					dfs(nr,nc);
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
			return false;
	}
	private static void setData() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
