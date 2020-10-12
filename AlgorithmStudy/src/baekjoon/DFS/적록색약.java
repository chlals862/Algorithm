package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 적록색약 {
	static int N, noRGB, isRGB;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<Integer> noRgbList;
	static ArrayList<Integer> isRgbList;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() throws IOException {
		isRgbList = new ArrayList<Integer>();
		noRgbList = new ArrayList<Integer>();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int color = map[row][col];
				if (map[row][col] == color && !visit[row][col]) {
					int noRGB = 0;
					dfs(row, col);
					noRgbList.add(noRGB);
				}
			}
		}
		isRGB();
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				int color = map[row][col];
				if(map[row][col] == color && !visit[row][col]) {
					int isRGB = 0;
					dfs(row,col);
					isRgbList.add(isRGB);
				}
			}
		}
		bw.write(noRgbList.size()+ " "+ isRgbList.size());
		bw.flush();
		bw.close();
	}

	private static void isRGB() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] == 'G') {
					map[row][col] = 'R';
				}
			}
		}
	}
	private static void dfs(int row, int col) {
		visit[row][col] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			int color = map[row][col];
			if (rangeCheck(nr, nc)) {
				if (map[nr][nc] == color && !visit[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}

	// 적록X -> R G B , 적록 O -> R-G , B
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visit = new boolean[N][N];
		for (int row = 0; row < N; row++) {
			String str = br.readLine();
			for (int col = 0; col < N; col++) {
				map[row][col] = str.charAt(col);
			}
		}

	}

}
