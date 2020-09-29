package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 생명게임1 {
	static int[][] map;
	static boolean[][] visit;
	static int[][] visit1;
	static Queue<int[]> q;
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		visit = new boolean[25][25];
		visit1 = new int[25][25];
		// 1. 생명이 없는 칸의 주위 8칸에 정확히 3마리의 생명이 존재하는 경우 다음 세대에 그 칸에서 생명이 탄생한다.
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map.length; col++) {
				if (map[row][col] == 0 && visit1[row][col] == 0 && !visit[row][col]) {
					q.add(new int[] { row, col });
					constraint1(row, col);
				}
			}
		}
		q.clear();
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map.length; col++) {
				if (map[row][col] == 1 && !visit[row][col]) {
					q.add(new int[] { row, col });
					constraint2(row, col);
				}
			}
		}
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map.length; col++) {
				if (visit1[row][col] == 9) {
					map[row][col] = 1;
				} else if (visit1[row][col] == 8) {
					map[row][col] = 0;
				} else if (visit1[row][col] == 7) {
					map[row][col] = 1;
				}
			}
		}
		printData();
	}

	private static void constraint2(int row, int col) {
		// 2. 생명이 있는 칸의 주위 8칸에 4마리 이상 또는 1마리 이하의 생명이 존재하는 경우 다음 세대에 그 칸의 생명은 죽는다.
		// 3. 생명이 있는 칸의 주위 8칸에 2마리 또는 3마리의 생명이 존재하는 경우 다음 세대에 그 칸의 생명은 생존한다.
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
							count++;
						}
					}
				}
				if (count <= 1 || count >= 4) {
					visit1[row][col] = 8;
				}
				if (count == 2 || count == 3) {
					visit1[row][col] = 7;
				}
			}
		}

	}

	private static void constraint1(int row, int col) {
		int cnt = 0; // 0을 기준으로 8방향 안에 3마리 존재 하는 경우 그 위치에 탄생.
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
						if (map[nr][nc] == 1 && visit1[nr][nc] == 0) {
							cnt++;
						}
					}
				}

			}
			if (cnt == 3) {
				visit1[row][col] = 9;
			}
		}

	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < 25 && nc >= 0 && nc < 25)
			return true;
		return false;
	}

	private static void setData() throws IOException {
		map = new int[25][25];

		for (int row = 0; row < map.length; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < map.length; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void printData() throws IOException {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map.length; col++) {
				bw.write(map[row][col] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
