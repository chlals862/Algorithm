package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치삼이의징검다리건너기 {
	static int N, K, result;
	static int wR, wC;
	static char[][] map;
	static int[][] visit;
	static boolean[][] pvisit;
	static Queue<int[]> q;
	static Queue<int[]> p;
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	private static boolean flag;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		p = new LinkedList<int[]>();
		p.add(new int[] { 0, 0 });
		pvisit[0][0] = true;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (visit[row][col] == 1) {
					q.add(new int[] { row, col });
				}
			}
		}
		
		water();
		if (flag) {
			System.out.println(result);
		} else
			System.out.println(-1);
	}

	

	private static void water() {
		
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
						if (visit[nr][nc] == 0) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = 1;
						}
					}
				}
			}
			result++;
			Move();
			if (flag)
				return;
			 else continue;
		}
	}
	private static void Move() {
		System.out.println("p.size = " + p.size());
		while (!p.isEmpty()) {
			int size = p.size();
			for (int i = 0; i < size; i++) {
				int[] peopleRC = p.poll();
				int cr = peopleRC[0];
				int cc = peopleRC[1];
				for (int dir = 0; dir < 8; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					System.out.println("?");
					if (rangeCheck(nr, nc)) {
						if (nr == N - 1 && nc == N - 1) {
							System.out.println("goal");
							flag = true;
							return;
						}
						if (map[nr][nc] == '1' && visit[nr][nc] == 1 && !pvisit[nr][nc]) {
							System.out.println("cr = " + cr + " cc = " + cc);
							System.out.println("??");
							p.add(new int[] { nr, nc });
							pvisit[nr][nc] = true;
						}
					}
				}
			}
			System.out.println("map");
			printData3();
			System.out.println("visit");
			printData();
			System.out.println("pvisit");
			printData2();
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
		K = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visit = new int[N][N];
		pvisit = new boolean[N][N];
		//visit[N-1][N-1] = 1;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			wR = Integer.parseInt(st.nextToken()) - 1;
			wC = Integer.parseInt(st.nextToken()) - 1;
			visit[wR][wC] = 1;
		}
		for (int row = 0; row < N; row++) {
			String sLine = br.readLine();
			for (int col = 0; col < N; col++) {
				map[row][col] = sLine.charAt(col);
			}
		}
	}
	private static void printData3() {
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
				System.out.print(pvisit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();

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
