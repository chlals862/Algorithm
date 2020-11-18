package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파핑파핑지뢰찾기_ing {
	static int K, N, result, startR, startC;
	static char[][] input;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static boolean flag, bfsFlag;
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
	}

	/*
	 * 0. while문 -> 전부 true일 때 (종료 조건) -> break걸기 1. numbering 2. 0인 곳부터 8방향 탐색 ->
	 * 숫자 나오는데 까지만 bfs탐색 3. 0인곳이 전부 방문 했다면 , 방문하지 않았고 주변에 지뢰가 있는 칸 수 만큼 ++;
	 */
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			input = new char[N][N];
			map = new int[N][N];
			visit = new boolean[N][N];
			q = new LinkedList<int[]>();
			for (int row = 0; row < N; row++) {
				String str = br.readLine();
				for (int col = 0; col < N; col++) {
					input[row][col] = str.charAt(col);
					if (input[row][col] == '*') {
						map[row][col] = -1;
						visit[row][col] = true;
					}
				}
			}
			logic(k);
		}
		bw.close();
	}

	private static void logic(int k) throws IOException {
		numbering();
		while (true) {
			bfsFlag = false;
			logic1();
			printVisit();
			System.out.println("result = " +result);
		}

	}

	private static void logic1() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == 0 && !visit[row][col]) {
					bfsFlag = true;
					startR = row;
					startC = col;
				}
			}
		}
		if (bfsFlag) {
			System.out.println("true");
			q.add(new int[] { startR, startR });
			visit[startR][startR] = true;
			bfs();
			result+=1;
		}
	}

	private static void bfs() {
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
						if (map[nr][nc] == 0 && !visit[nr][nc]) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
						} else if (map[nr][nc] > 0 && !visit[nr][nc]) {
							visit[nr][nc] = true;
						}
					}
				}
			}
		}
	}

	private static void numbering() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (!visit[row][col]) {
					for (int dir = 0; dir < 8; dir++) {
						int nr = row + dr[dir];
						int nc = col + dc[dir];
						if (rangeCheck(nr, nc)) {
							if (map[nr][nc] == -1)
								map[row][col] += 1;
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

	private static void printVisit() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void printMap() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
