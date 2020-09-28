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

public class 호수의수구하기 {
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static ArrayList<Integer> list;
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
		list = new ArrayList<Integer>();
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (map[row][col] == 'L' && !visit[row][col]) {
					int num = 1;
					q.add(new int[] { row, col });
					visit[row][col] = true;
					list.add(num);
					bfs(num);
				}
			}
		}
		bw.write(list.size()+"\n");
		bw.flush();
		bw.close();

	}

	private static void bfs(int num) {
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
						if (map[nr][nc] == 'L' && !visit[nr][nc]) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
						}
					}
				}
			}
			num++;
		}

	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int row = 0; row < R; row++) {
			String sLine = br.readLine().replace(" ", "");
			for (int col = 0; col < C; col++) {
				map[row][col] = sLine.charAt(col);
			}
		}
	}
}
