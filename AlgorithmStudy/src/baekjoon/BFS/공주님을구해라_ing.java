package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라_ing {
	static int R, C, T, item,time;
	static int[][] map;
	static boolean[][][] visit;
	static boolean flag;
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
		int item = 0;
		q.add(new int[] { 0, 0,item});
		visit[0][0][item] = true;
		bfs(item);
		if(time <= T && flag == true) {
			bw.write(time + "\n");
			
		}else {
			bw.write("Fail");
		}
		bw.flush();
		bw.close();
	}

	private static void bfs(int item) {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(cr == R-1 && cc == C-1) {
					flag = true;
					return;
				}
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(item > 0) {
						if(rangeCheck(nr,nc)) {
							if(!visit[nr][nc][item]) {
								map[nr][nc] = 0;
								q.add(new int[] {nr,nc,item});
								visit[nr][nc][item] = true;
							}
						}
					}
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] == 0 && !visit[nr][nc][item]) {
								q.add(new int[] {nr,nc});
								visit[nr][nc][item] = true;
							}
							if(map[nr][nc] == 2 && !visit[nr][nc][item]) {
								item++;
								map[nr][nc] = 0;
								q.add(new int[] {nr,nc,item});
								visit[nr][nc][item] = true;
							}
						}
				}
			}
			time++;
		}
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
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C][2];

		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
