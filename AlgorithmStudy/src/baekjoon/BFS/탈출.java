package baekjoon.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출 {
	static int R, C;
	static char[][] forest;
	static boolean[][] go;
	static boolean[][] water;
	static boolean flag;
	static int time, answer;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<GW> q = new LinkedList<GW>();

	static class GW {
		int goR;
		int goC;
		int waterR;
		int waterC;
		int id;

		public GW(int goR, int goC, int waterR, int waterC, int id) {
			this.goR = goR;
			this.goC = goC;
			this.waterR = waterR;
			this.waterC = waterC;
			this.id = id;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		forest = new char[R][C];
		go = new boolean[R][C];
		water = new boolean[R][C];
		ArrayList<GW> list = new ArrayList<GW>();
		for (int row = 0; row < R; row++) {
			String sline = sc.nextLine();
			forest[row] = sline.toCharArray();
			for (int col = 0; col < C; col++) {
				if (forest[row][col] == 'S') {
					list.add(new GW(row, col, -1, -1, 1));
					go[row][col] = true;
				} else if (forest[row][col] == '*') {
					list.add(new GW(-1, -1, row, col, 2));
					water[row][col] = true;
				}
			}
		}
		// id 정렬
		Collections.sort(list, new Comparator<GW>() {

			@Override
			public int compare(GW o1, GW o2) {
				return Integer.compare(o1.id, o2.id);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			q.add(list.get(i));
		}
		BFS();
		if (flag == true) {
			System.out.println(answer);
		} else {
			System.out.println("KAKTUS");
		}
	}

	private static void BFS() {
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			//System.out.println("BFS전");
			//view();
			for (int i = 0; i < size; i++) {
				GW current = q.poll();
				switch (current.id) {// if (current.id == 1) {
				case 1:
					if (water[current.goR][current.goC] == false) {
						moveGo(current);
						if (flag == true) {
							time++;
							answer = time;
							return;
						}
					}
				case 2:
						moveWater(current);
						break;
				}
			}
			//System.out.println("BFS 후");
			//view();
			time++;
		}

	}

	private static void moveWater(GW current) {
		int currentR = current.waterR;
		int currentC = current.waterC;

		for (int dir = 0; dir < 4; dir++) {
			int nr = currentR + dr[dir];
			int nc = currentC + dc[dir];

			if (rangeCheck(nr, nc) && forest[nr][nc] != 'D' && forest[nr][nc] != 'X' && water[nr][nc] == false) {
				q.add(new GW(-1, -1, nr, nc, 2));
				water[nr][nc] = true;
				 forest[nr][nc] = '*';
			}
		}

	}

	private static void moveGo(GW current) {
		int currentR = current.goR;
		int currentC = current.goC;

		for (int dir = 0; dir < 4; dir++) {
			int nr = currentR + dr[dir];
			int nc = currentC + dc[dir];
			if(rangeCheck(nr, nc) && forest[nr][nc] == 'D') {
				flag = true;
				return;
			}
			if (rangeCheck(nr, nc) && forest[nr][nc] != '*' && forest[nr][nc] != 'X' && go[nr][nc] == false) {
				q.add(new GW(nr, nc, -1, -1, 1));
				go[nr][nc] = true;
				 forest[nr][nc] = 'S';
			}

		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
			return true;
		}
		return false;
	}

	private static void view() {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				System.out.print(forest[row][col] + "");
			}
			System.out.println();
		}
		System.out.println();
	}

}
