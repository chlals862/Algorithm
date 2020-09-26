package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 캔디팡 {
	static int cnt;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<Integer> list;
	static Queue<int[]> q;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		list = new ArrayList<Integer>();
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				q.add(new int[] { row, col });
				visit[row][col] = true;
				bfs();
			}
		}
		bw.write(list.size()+"\n");
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		int cnt = 1;
		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int color = map[cr][cc];
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) {
						if (map[nr][nc] == color && !visit[nr][nc]) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
							cnt++;
						}
					}
				}
			}
		}
		if (cnt >= 3) {
			list.add(result);
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < 7 && nc >= 0 && nc < 7)
			return true;
		return false;
	}
	private static void setData() throws IOException {
		map = new int[7][7];
		visit = new boolean[7][7];
		for (int row = 0; row < 7; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < 7; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
