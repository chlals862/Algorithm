package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수_복습 {
	static int R, C;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static ArrayList<Integer> list;
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			visit = new boolean[R][C];
			list = new ArrayList<Integer>();
			q = new LinkedList<int[]>();
			for (int row = 0; row < R; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < C; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			logic();
			if (R == 0 && C == 0) 
				return;
			bw.write(list.size() + "\n");
			bw.flush();
		}
	}

	private static void logic() throws IOException {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {

				if (map[row][col] == 1 && !visit[row][col]) {
					int result = 0;
					queueAdd(row, col);
					list.add(result);
					bfs();
				}
			}
		}
	}
	private static void bfs() {
		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for (int dir = 0; dir < 8; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) {
						if (map[nr][nc] == 1 && !visit[nr][nc]) {
							queueAdd(nr, nc);
						}
					}
				}
			}
			result++;
		}
	}
	private static void queueAdd(int nr, int nc) {
		q.add(new int[] { nr, nc });
		visit[nr][nc] = true;
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
}
