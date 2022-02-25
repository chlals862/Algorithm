package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Grid {
	static int R, C, res;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for (int row = 0; row < R; row++) {
			String str = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = str.charAt(col) - '0';
			}
		}
		BFS();
		if (flag)
			bw.write(res + "\n");
		else
			bw.write("IMPOSSIBLE\n");
		bw.flush();
		bw.close();
	}

	private static void BFS() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 });
		visit[0][0] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if (cr == R - 1 && cc == C - 1) {
					flag = true;
					break;
				}
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir] * map[cr][cc];
					int nc = cc + dc[dir] * map[cr][cc];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc]) {
						q.add(new int[] { nr, nc });
						visit[nr][nc] = true;
					}
				}
			}
			if(flag) break;
			res++;
		}
	}
}
