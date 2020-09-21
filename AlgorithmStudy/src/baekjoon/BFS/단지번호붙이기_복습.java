package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 단지번호붙이기_복습 {
	static int N, num;
	static int count;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
		printData();
	}

	private static void printData() throws IOException {
		bw.write(list.size() + "\n");
		Collections.sort(list);
		for (Integer result : list) {
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void logic() {
		q = new LinkedList<int[]>();
		list = new ArrayList<Integer>();
		int num = 1;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == 1 && !visit[row][col]) {
					count = 1;
					queAdd(row, col);
					map[row][col] = num;
					bfs(num);
					num++;
					list.add(count);
				}
			}
		}
	}

	private static void queAdd(int row, int col) {
		q.add(new int[] { row, col });
		visit[row][col] = true;
	}

	private static void bfs(int num) {
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
						if (map[nr][nc] != 0 && !visit[nr][nc]) {
							queAdd(nr, nc);
							map[nr][nc] = num;
							count++;
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

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int row = 0; row < N; row++) {
			String[] str = br.readLine().split("");
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(str[col]);
			}
		}

	}
}
