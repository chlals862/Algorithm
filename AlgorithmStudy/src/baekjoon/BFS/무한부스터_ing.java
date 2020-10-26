package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 무한부스터_ing {
	static int R, C,time;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() {
		q.add(new int[] { 0, 0 });
		visit[0][0] = true;
		time = 1;
		bfs();
		printVisit();
		System.out.println(time);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int booster = map[cr][cc];
				System.out.println("Booster = " + booster);
				for (int dir = 0; dir < 4; dir++) {
					for (int k = 0; k < booster; k++) {
						int nr = cr + dr[dir] + k;
						int nc = cc + dc[dir] + k;
						if (rangeCheck(nr, nc)) {
							if(nr == R-1 && nc == C-1) {
								return;
							}
							if(!visit[nr][nc]) {
								q.add(new int[] {nr,nc});
								visit[nr][nc] = true;
							}
						}
					}
				}
			}
			time++;
			printVisit();
		}
	}

	private static void printVisit() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(visit[row][col]+"");
			}
			System.out.println();
		}
		System.out.println();
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
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		printMap();
	}

	private static void printMap() {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
