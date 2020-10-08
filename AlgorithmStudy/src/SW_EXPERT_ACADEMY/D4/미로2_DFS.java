package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 미로2_DFS {
	static int testCase;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			testCase = Integer.parseInt(st.nextToken());
			map = new int[100][100];
			visit = new boolean[100][100];
			flag = false;
			for (int row = 0; row < 100; row++) {
				String[] str = br.readLine().split("");
				for (int col = 0; col < 100; col++) {
					map[row][col] = Integer.parseInt(str[col]);
				}
			}
			logic();
			if (flag) {
				bw.write("#" + t + " " + 1 + "\n");
			} else
				bw.write("#" + t + " " + 0 + "\n");
		}
		bw.flush();
		bw.close();

	}

	private static void logic() {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (map[row][col] == 2 && !visit[row][col]) {
					dfs(row, col);
				}
			}
		}

	}

	private static void dfs(int row, int col) {
		visit[row][col] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if (rangeCheck(nr, nc)) {
				if (map[nr][nc] == 3) {
					flag = true;
					return;
				}
				if (map[nr][nc] == 0 && !visit[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100)
			return true;
		return false;
	}
}
