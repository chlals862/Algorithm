package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기1_복습 {
	static int R, C, time;
	static boolean flag;
	static int[][] map;
	static boolean[][][] visit;
	static Queue<int[]> q;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0, 1 });
		visit[0][0][1] = true;
		time = 1;
		bfs();
		if(R-1 == 0 && C-1 == 0 ) {
			bw.write(1+"");
		}
		else if (flag)
			bw.write(time + 1 + "");
		else  {
			bw.write(-1 + "");
		}
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int ca = currentRC[2];
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (nr == R - 1 && nc == C - 1) {
						flag = true;
						return;
					}
					if (rangeCheck(nr, nc)) {
						if (map[nr][nc] == 0 && !visit[nr][nc][ca]) {
							q.add(new int[] { nr, nc, ca });
							visit[nr][nc][ca] = true;
						}
					}
					if (ca > 0) {
						if (rangeCheck(nr, nc)) {
							if (map[nr][nc] == 0 || map[nr][nc] == 1 && !visit[nr][nc][ca - 1]) {
								q.add(new int[] { nr, nc, ca - 1 });
								visit[nr][nc][ca - 1] = true;
							}
						}
					}
				}
			}
			time++;
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
		map = new int[R][C];
		visit = new boolean[R][C][2];
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine().replace("", " "));
			for (int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}