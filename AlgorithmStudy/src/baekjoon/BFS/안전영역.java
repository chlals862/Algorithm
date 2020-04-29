package baekjoon.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역 {

	static int N;
	static int area;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visit;
	static int num;
	static Queue<int[]> q = new LinkedList<int[]>();
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 행X열
		map = new int[101][101];
		visit = new boolean[101][101];
		list = new ArrayList<Integer>();

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				map[row][col] = sc.nextInt();
			}
		}
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] > N) {

					area = 0;
					q.add(new int[] { row, col });

					System.out.println("row = " + row + " col = " + col);
					BFS();
					list.add(area);
				}
			}
		}
		//System.out.println(Collections.max(list));
	}

	private static void BFS() {
		while (!q.isEmpty()) {
			int size = q.size();
			// System.out.println("BFS 전 ");

			for (int i = 0; i < size; i++) {
				int[] current = q.poll();

				for (int dir = 0; dir < 4; dir++) {
					int nr = current[0] + dr[dir];
					int nc = current[1] + dc[dir];

					if (rangeCheck(nr, nc)) {
//						if (visit[nr][nc] == false && map[nr][nc] <= N) {
//							q.add(new int[] { nr, nc });
//							visit[nr][nc] = true;
//						}
						if (visit[nr][nc] == false && map[nr][nc] > N) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
							area++;
						}
					}
				}
			}

		}

	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr <= N - 1 && nc >= 0 && nc <= N - 1) {
			return true;
		}
		return false;
	}

	private static void view() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void view2() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
