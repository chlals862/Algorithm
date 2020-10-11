package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 점프왕쩰리Large {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {0,0,1,0};
	static int[] dc = {0,1,0,0};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		setData();
		printData();
	}
	private static void printData() throws IOException {
		if(flag) bw.write("HaruHaru"+"\n");
		else bw.write("Hing"+"\n");
		bw.flush();
		bw.close();
	}
	private static void setData() throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
	}
	private static void dfs(int row, int col) {
		visit[row][col] = true;
		int jump = map[row][col];
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir]*jump;
			int nc = col + dc[dir]*jump;
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == -1) {
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
		if(nr >= 0 && nr < N && nc >= 0 && nc < N ) return true;
			return false;
	}
}
