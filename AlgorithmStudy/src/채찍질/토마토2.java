package 채찍질;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토2 {
	static int time;
	static int C, R, H;
	static int[][][] box;
	static boolean[][][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dh = { -1, 1 };
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		setData();
		if (end())
			System.out.println(0);
		else {
			bfs();
			if (end())
				System.out.println(time-1);
			else
				System.out.println(-1);
		}
	}

	private static boolean end() {
		for (int h = 0; h < H; h++) {
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					if (box[row][col][h] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int ch = currentRC[2];

				// 현재층 4방향
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];

					if (rangeCheck(nr, nc)) {
						if (visit[nr][nc][ch] == false && box[nr][nc][ch] == 0) {
							q.add(new int[] { nr, nc, ch });
							visit[nr][nc][ch] = true;
							box[nr][nc][ch] = 1;
						}
					}
				}
				for (int dir = 0; dir < 2; dir++) {
					int nh = ch + dh[dir];

					if (heightCheck(nh)) {
						if (visit[cr][cc][nh] == false && box[cr][cc][nh] == 0) {
							q.add(new int[] { cr, cc, nh });
							visit[cr][cc][nh] = true;
							box[cr][cc][nh] = 1;
						}
					}
				}
			}
			time++;
		}
	}

	private static boolean heightCheck(int nh) {
		if (nh >= 0 && nh < H)
			return true;
		return false;
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
		H = Integer.parseInt(st.nextToken());

		box = new int[R][C][H];
		visit = new boolean[R][C][H];
		q = new LinkedList<int[]>();
		for (int height = 0; height < H; height++) {
			for (int row = 0; row < R; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < C; col++) {
					box[row][col][height] = Integer.parseInt(st.nextToken());
					if (box[row][col][height] == 1) {
						q.add(new int[] { row, col, height });
						visit[row][col][height] = true;
						box[row][col][height] = 1;
					}

				}
			}
		}

		//view();
	}

	private static void view() {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				System.out.print(box[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
}
