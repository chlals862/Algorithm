package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기_ing {
	static int N, num, time;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		num = 1;
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		// printData();
		logic();
	}

	private static void logic() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == 1 && !visit[row][col]) {
					q.add(new int[] { row, col });
					visit[row][col] = true;
					map[row][col] = num;
					bfs();
					num++;
				}
			}
		}
		printData();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == 0 && !visit[row][col]) {
					q.add(new int[] { row, col });
					visit[row][col] = true;
					bfs2();
				}
			}
		}
		System.out.println(time);
	}

	private static void bfs2() {
		System.out.println("??");
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(map[cr][cc] == 2 || map[cr][cc] == 3) {
					return;
				}
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) {
						if(map[nr][nc] == 0 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			time++;
			printData();
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) {
						if (map[nr][nc] == 1 && !visit[nr][nc]) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
							map[nr][nc] = num;
						}
					}
				}
			}
		}

	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}

	private static void printData() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
