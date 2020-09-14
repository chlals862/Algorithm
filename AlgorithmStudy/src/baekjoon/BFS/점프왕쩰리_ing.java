package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프왕쩰리_ing {
	static int N;
	static int[][] map;
	static boolean[][][] visit;
	static boolean flag;
	static Queue<int[]> q;
	static int[] dr = {1};
	static int[] dc = {1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		int count = map[0][0];
		q.add(new int[] { 0, 0, count});
		visit[0][0][count] = true;
		bfs();
		if(flag) {
			bw.write("HaruHaru" + "\n");
		} else {
			bw.write("Hing");
		}
		bw.flush();
		bw.close();
		
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			System.out.println("size = " + size);
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int ca = currentRC[2];
				for (int dir = 0; dir < 1; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (nr == N-1 && nc == N-1 && ca == 0 && map[nr][nc] == -1) {
						System.out.println("ca = " + ca);
						flag = true;
						return;	
					}
					if (ca > 0) {
						if (rangeCheck(nr, nc)) {
							if (map[nr][nc] > 0 && !visit[nr][nc][ca - 1]) {
								q.add(new int[] {nr,nc,ca-1});
								visit[nr][nc][ca-1] = true;
								ca = map[nr][nc];
								System.out.println("ca 22= " + map[nr][nc]);
							}
						}
					}
				}
				System.out.println("ca = " + ca);
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
		visit = new boolean[N][N][101];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
