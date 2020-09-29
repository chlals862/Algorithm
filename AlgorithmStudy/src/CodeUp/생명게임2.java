package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
조건1
생명이 없는 칸의 주위 8칸에 정확히 3마리의 생명이 존재하는 경우 다음 세대에 그 칸에서 생명이 탄생한다.
조건2
생명이 있는 칸의 주위 8칸에 4마리 이상 또는 1마리 이하의 생명이 존재하는 경우 다음 세대에 그 칸의 생명은 죽는다.
조건3
생명이 있는 칸의 주위 8칸에 2마리 또는 3마리의 생명이 존재하는 경우 다음 세대에 그 칸의 생명은 생존한다.

0 -> 생명 없음 
1 -> 생명 있음

x -> 생명이 태어나기 위한 이웃의 수
y -> 생명이 살기 위해 필요한 최소 이웃 수
z -> 생명이 죽는 최소 이웃 수
*/
public class 생명게임2 {
	static int R, C;
	static int x, y, z, k;
	static int t1, t2;
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
		// 1번 조건 수행
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (map[row][col] == 0) {
					q.add(new int[] { row, col });
					constraint1(row, col);
				}
			}
		}
		q.clear();
		// 2,3번 조건 수행
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (map[row][col] == 1) {
					q.add(new int[] { row, col });
					constraint2(row, col);
				}
			}
		}
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (visit1[row][col] == 9 || visit1[row][col] == 8) {
					map[row][col] = 1;
				}
				if (visit1[row][col] == 7) {
					map[row][col] = 0;
				}
			}
		}
		printData();
	}

	private static void constraint2(int row, int col) {
		int num = 0;
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
						if (map[nr][nc] == 1) {
							num++;
						}
					}
				}
			}
			if (num < y || num >= z) {
				visit1[row][col] = 7;
			}
			if (num >= y && num < z) {
				visit1[row][col] = 8;
			} 
			
			t2++;
			if (t2 == k)
				return;
		}

	}

	private static void constraint1(int row, int col) {
		int num2 = 0;
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
							num2++;
						}
					}
				}
			}
			if (num2 == x) {
				visit1[row][col] = 9;
			}
			t1++;
			if (t1 == k)
				return;
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
		visit = new boolean[R][C];
		visit1 = new int[R][C];
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		z = Integer.parseInt(st.nextToken());
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
	}

	private static void printData() throws IOException {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				bw.write(map[row][col] +" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
