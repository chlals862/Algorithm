package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 움직이는미로탈출 {
	static int result;
	static char[][] map;
	static boolean[][] visit;
	static boolean flag;
	static Queue<int[]> q;
	static int[] dr = { 0, -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, 1, 0, -1, -1, 1, 1, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		q.add(new int[] { 7, 0 });
		bfs();
		if(flag) {
			bw.write(1+"\n");
		}else {
			bw.write(0+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			visit = new boolean[8][8];
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(map[cr][cc] == '#') continue;
				if(cr == 0) {
					flag = true;
					return;
				}
				for (int dir = 0; dir < 9; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) {
						if(map[nr][nc] == '.' && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			downWall();
		}
	}

	private static void downWall() {
		for(int row = 7; row>= 0; row--) {
			for(int col=0;col<8;col++) {
				if(row == 0) {
					map[row][col] = '.';
				} else {
					map[row][col] = map[row-1][col];
				}
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= 7 && nc >= 0 && nc <= 7) return true;
			return false;
	}
	private static void setData() throws IOException {
		map = new char[8][8];
		for (int row = 0; row < 8; row++) {
			String sLine = br.readLine();
			for (int col = 0; col < 8; col++) {
				map[row][col] = sLine.charAt(col);
			}
		}
	}
}
