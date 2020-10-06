package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 침투 {
	static int R, C;
	static char[][] map;
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
		for (int col = 0; col < C; col++) {
			if (map[0][col] == '0' && !visit[0][col]) {
				dfs(0, col);
			}
		}
		if (flag) {
			bw.write("YES" + "\n");
		} else
			bw.write("NO" + "\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int row, int col) {
		if (visit[R - 1][col]) {
			flag = true;
		}
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		for (int dir = 0; dir < 4; dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if (rangeCheck(nr, nc)) {
				if (map[nr][nc] == '0' && !visit[nr][nc]) {
					visit[nr][nc] = true;
					dfs(nr, nc);
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int row = 0; row < R; row++) {
			String str = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = str.charAt(col);
			}
		}
	}
}
