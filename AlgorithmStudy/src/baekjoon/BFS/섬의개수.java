package baekjoon.BFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬의개수 {
	static int R, C;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			C = sc.nextInt();
			R = sc.nextInt();
			map = new int[R][C];
			visit = new boolean[R][C];
			list = new ArrayList<Integer>();
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					map[row][col] = sc.nextInt();
				}
			}
			logic();
			if (R == 0 && C == 0) {
				return;
			}
			System.out.println(list.size());
		}
	}

	private static void logic() {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (map[row][col] == 1 && !visit[row][col]) {
					int count = 0;
					q.add(new int[] { row, col });
					visit[row][col] = true;
					list.add(count);
					bfs();
				}
			}
		}

	}

	private static void bfs() {
		int count = 0;
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
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
						}
					}
				}
			}
			count++;
		}

	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
}
