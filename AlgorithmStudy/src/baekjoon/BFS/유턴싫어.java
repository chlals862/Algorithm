package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 유턴싫어 {
	static int R, C, num;
	static char[][] map;
	static boolean flag;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int row = 0; row < R; row++) {
			String sLine = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = sLine.charAt(col);
			}
		}
		int ans = 0;
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				int cnt = 0;
				if (map[row][col] == '.') {
					for (int dir = 0; dir < 4; dir++) {
						int nr = row + dr[dir];
						int nc = col + dc[dir];
						if (rangeCheck(nr, nc)) {
							if (map[nr][nc] == 'X')
								cnt++;
						} else
							cnt++;
						if (cnt >= 3) {
							ans = 1;
							break;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
}
