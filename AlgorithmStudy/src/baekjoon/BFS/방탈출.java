package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 방탈출 {
	static class Point {
		int x, y, step;

		public Point(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
	static int N, M;
	static int maxStep = 0;
	static int pwd;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] map;

	static void bfs(int row, int col) {
		boolean[][] visit = new boolean[N][M];
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(row, col, 1));
		visit[row][col] = true;
		int current = map[row][col];
		
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size;i++) {
			Point now = q.poll();
			if (maxStep < now.step) {
				maxStep = now.step;
				pwd = current + map[now.x][now.y];
			} else if (maxStep == now.step) {
				pwd = Math.max(pwd, current + map[now.x][now.y]);
			}
			for (int dir = 0; dir < 4; dir++) {
				int nr = now.x + dy[dir];
				int nc = now.y + dx[dir];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(map[nr][nc] != 0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						q.add(new Point(nr, nc, now.step + 1));
					}
				}
			}
		}
	}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (map[row][col] != 0)
					bfs(row, col);
			}
		}
		bw.write(pwd + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
