package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
5
1 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 1
0 0 0 0 1 -> 2
*/
public class 다리만들기_ing {
	static int N, num, result, max;
	static ArrayList<Integer> min;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() {
		q = new LinkedList<int[]>();
		num = 1;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == 1 && !visit[row][col]) {
					q.add(new int[] { row, col });
					visit[row][col] = true;
					map[row][col] = num;
					islandNum(num);
					num++;
				}
			}
		}
		System.out.println("섬 정보");
		printData();
		min = new ArrayList<Integer>();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				// 섬들에서 시작
				if (map[row][col] != 0) {
					int count = map[row][col]; // 현재 섬의 번호
					q.add(new int[] { row, col });
					bfs(count);
					min.add(result);
				}
			}
		}

	}

	private static void bfs(int count) {
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
						if(map[nr][nc] != count && map[nr][nc] != 0) return; //자신섬이 아니고,0이 아니면
						if(map[nr][nc] == count && visit[nr][nc]) continue; //자신섬이고,방문했으면 
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
			result++;
		}
	}

	private static void islandNum(int num) {

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
	}

	private static void printData() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void printData2() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}