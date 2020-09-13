package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 윌리암슨수액빨이딱따구리가정보섬에올라온이유 {

	static int R, C, time;
	static char[][] map;
	static boolean[][] visit;
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
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (map[row][col] == '2' && !visit[row][col]) {
					queAdd(row, col);
					bfs();
				}
			}
		}
		if(flag) {
			bw.write("TAK" + "\n" + time);
		} else {
			bw.write("NIE");
		}
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if (map[cr][cc] != '1') {
					if (map[cr][cc] == '3' || map[cr][cc] == '4' || map[cr][cc] == '5') {
						flag = true;
						return;
					}
				}
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) {
						if (map[nr][nc] != '1' && !visit[nr][nc]) {
							queAdd(nr, nc);
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
	private static void queAdd(int row, int col) {
		q.add(new int[] { row, col });
		visit[row][col] = true;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int row = 0; row < R; row++) {
			String sLine = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = sLine.charAt(col);
			}
		}
	}
}
