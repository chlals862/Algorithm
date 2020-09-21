package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프왕쪨리Small {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static boolean flag;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };
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
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
			queAdd(0, 0);
			bfs();
			if (flag) {
				bw.write("HaruHaru");
			} else if (!flag)
				bw.write("Hing");
			bw.flush();
		
	}

	private static void queAdd(int row, int col) {
		q.add(new int[] { row, col });
		visit[row][col] = true;
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int count = map[cr][cc];
				if (cr == N - 1 && cc == N - 1) {
					flag = true;
					return;
				}
				for (int dir = 0; dir < 2; dir++) {
					int nr = cr + dr[dir] * count;
					int nc = cc + dc[dir] * count;
					if (rangeCheck(nr, nc)) {
						if (!visit[nr][nc]) {
							queAdd(nr, nc);
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
}
