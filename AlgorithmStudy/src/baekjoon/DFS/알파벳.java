package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 알파벳 {
	static int R, C, max,cnt;
	static int[][] map;
	static boolean[] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() {
		//0,0이 C일 경우 visit의 3번째 true처리
		int first = map[0][0];
		visit[first] = true;
		dfs(0, 0, 1);
		System.out.println(max);
		//printMap();
	}

	private static void dfs(int row, int col, int cnt) {
		if (max < cnt) {
			max = cnt;
		}
		for (int dir = 0; dir < 4; dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if (rangeCheck(nr, nc)) {
				int num = map[nr][nc];
				if (!visit[num]) {
					visit[num] = true;
					dfs(nr, nc, cnt + 1);
					visit[num] = false;
					//System.out.println("num2 = " + visit[num]);
				}
			}
		}
		//printMap();
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
		map = new int[R][C];
		visit = new boolean[26];
		for (int row = 0; row < R; row++) {
			String str = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = str.charAt(col) - 'A';
			}
		}
	}
//
//	private static void printMap() {
//		for (int row = 0; row < visit.length; row++) {
//			System.out.print(visit[row] + " ");
//			System.out.println();
//		}
//	}
}
