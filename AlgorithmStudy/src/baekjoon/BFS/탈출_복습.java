package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_복습 {
	static int R, C;
	static int result,time;
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][] gVisit;
	static boolean[][] wVisit;
	static ArrayList<GW> list;
	static Queue<GW> q = new LinkedList<GW>();

	static class GW {
		int gR;
		int gC;
		int wR;
		int wC;
		int id;

		public GW(int gR, int gC, int wR, int wC, int id) {
			this.gR = gR;
			this.gC = gC;
			this.wR = wR;
			this.wC = wC;
			this.id = id;
		}

	}

	public static void main(String[] args) throws IOException {

		inputData();
		BFS();
		if(flag == true) {
			bw.write(result+"\n");
		}else {
			bw.write("KAKTUS");
		}
		bw.flush();
	}

	private static void BFS() throws IOException {
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				GW currentRC = q.poll();

				switch (currentRC.id) {
				case 1:
					if (wVisit[currentRC.gR][currentRC.gC] == false) {
						gMove(currentRC);

						if(flag == true) {
							time++;
							result = time;
							return;
						}
					}

				case 2:
					wMove(currentRC);
					break;
				}// switch

			}
			time++;
		}
	}

	// 물 이동  장애물,소굴X
	private static void wMove(GW currentRC) {
		int currentR = currentRC.wR;
		int currentC = currentRC.wC;

		for(int dir=0;dir<4;dir++) {
			int nr = currentR + dr[dir];
			int nc = currentC + dc[dir];

			if(rangeCheck(nr,nc) && wVisit[nr][nc] == false && map[nr][nc] != 'X' && map[nr][nc] != 'D') {
				q.add(new GW(-1, -1, nr, nc, 2));
				wVisit[nr][nc] = true;
				map[nr][nc] = '*';
			}
		}
	}

	// 고슴도치 이동 장애물,불 이동, 이동했던곳 X
	private static void gMove(GW currentRC) {
		int currentR = currentRC.gR;
		int currentC = currentRC.gC;

		for (int dir = 0; dir < 4; dir++) {
			int nr = currentR + dr[dir];
			int nc = currentC + dc[dir];

			if(rangeCheck(nr,nc) && map[nr][nc] == 'D') {
				flag = true;
				return;
			}
			if (rangeCheck(nr, nc) && gVisit[nr][nc] == false && map[nr][nc] != '*' && map[nr][nc] != 'X') {
				q.add(new GW(nr, nc, -1, -1, 1));
				gVisit[nr][nc] = true;
				map[nr][nc] = 'S';
			}
		}
		time++;
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}

	private static void inputData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		gVisit = new boolean[R][C];
		wVisit = new boolean[R][C];

		for (int row = 0; row < R; row++) {
			String sLine = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row] = sLine.toCharArray();
			}
		}

		list = new ArrayList<GW>();

		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (map[row][col] == 'S') {
					list.add(new GW(row, col, -1, -1, 1));
					gVisit[row][col] = true;

				} else if (map[row][col] == '*') {
					list.add(new GW(-1, -1, row, col, 2));
					wVisit[row][col] = true;
				}
			}
		}
		Collections.sort(list, new Comparator<GW>() {

			@Override
			public int compare(GW o1, GW o2) {
				return Integer.compare(o1.id, o2.id);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			q.add(list.get(i));
		}

	}

	private static void view() {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
		System.out.println();

	}
}
