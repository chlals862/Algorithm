package baekjoon.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 불_1 {

	static int N, C, R;
	static int answer;
	static char[][] map;
	static boolean[][] sVisit;
	static boolean[][] fVisit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean flag;
	static Queue<SF> q = new LinkedList<SF>();
	static class SF {
		int sRow;
		int sCol;
		int fRow;
		int fCol;
		int id;
		public SF(int sRow, int sCol, int fRow, int fCol, int id) {
			this.sRow = sRow;
			this.sCol = sCol;
			this.fRow = fRow;
			this.fCol = fCol;
			this.id = id;
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 테스트 케이스 수
		for (int i = 0; i < N; i++) {
			C = sc.nextInt(); // 열
			R = sc.nextInt(); // 행
			sc.nextLine();
		
			map = new char[R][C];
			sVisit = new boolean[R][C];
			fVisit = new boolean[R][C];
			//BFS돌때마다 flag변수 && queue 클리어하여 초기화 해줘
			flag = false;
			q.clear();
			ArrayList<SF> list = new ArrayList<SF>();

			for (int row = 0; row < R; row++) {
				String sline = sc.nextLine();
				map[row] = sline.toCharArray();
				for (int col = 0; col < C; col++) {
					if (map[row][col] == '@') {
						list.add(new SF(row, col, -1, -1, 1));
						sVisit[row][col] = true;
					} else if (map[row][col] == '*') {
						list.add(new SF(-1, -1, row, col, 2));
						fVisit[row][col] = true;
					}
				}
			}
			Collections.sort(list, new Comparator<SF>() {
				@Override
				public int compare(SF o1, SF o2) {
					return Integer.compare(o1.id, o2.id);
				}
			});
			for (int j = 0; j < list.size(); j++) {
				q.add(list.get(j));
			}
			BFS();
		
			if (flag == true) {
				System.out.println(answer);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
	private static void BFS() {
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				SF current = q.poll();
				switch (current.id) {
				case 1:
					if (fVisit[current.sRow][current.sCol] == false) {
						sMove(current);
						if (flag == true) {
							time++;
							answer = time;
							return;
						}
					}
				case 2:
					fMove(current);
					break;
				}
			}
			time++;
		}
	}
	private static void fMove(SF current) {
		int currentR = current.fRow;
		int currentC = current.fCol;
		
		for (int dir = 0; dir < 4; dir++) {
			int nr = currentR + dr[dir];
			int nc = currentC + dc[dir];

			if (rangeCheck(nr, nc) && fVisit[nr][nc] == false && map[nr][nc] != '#') {
				q.add(new SF(-1, -1, nr, nc, 2));
				fVisit[nr][nc] = true;
			}
		}
	}
	private static void sMove(SF current) {
		int currentR = current.sRow;
		int currentC = current.sCol;
		for (int dir = 0; dir < 4; dir++) {
			int nr = currentR + dr[dir];
			int nc = currentC + dc[dir];

			if (rangeCheck(nr, nc) && sVisit[nr][nc] == false && map[nr][nc] != '#' && map[nr][nc] != '*') {
				q.add(new SF(nr, nc, -1, -1, 1));
				sVisit[nr][nc] = true;
				// 영역 밖을 벗어날 때 -> 탈출
			} else if (rangeCheck(nr, nc) == false) {
				flag = true;
				return;
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
			return true;
		}
		return false;
	}
}
