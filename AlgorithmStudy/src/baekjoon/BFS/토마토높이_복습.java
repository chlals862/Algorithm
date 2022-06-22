package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토높이_복습 {
	static int C, R, H;
	static int time;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dh = { -1, 1 };
	static int[][][] box;
	static boolean[][][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		C = sc.nextInt();
		R = sc.nextInt();
		H = sc.nextInt();
		box = new int[R][C][H];
		visit = new boolean[R][C][H];

		// 토마토가 있는곳 조사
		for (int height = 0; height < H; height++) {
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					box[row][col][height] = sc.nextInt();

					// 토마토가 있는 곳을 찾아서 있으면
					if (box[row][col][height] == 1) {
						// 큐에 해당 row,col,height를 넣고, 방문처리 및 1로 바꿈
						insertQueue(row, col, height);
					}
				}
			}
		}
		//view();
		// 저장될 때부터 모든 토마토가 익어있는 상태면 0을 출력,그렇지 못하면 -1을 출력
		if (check() == false) {
			System.out.println("0");
		} else {
			BFS();
		// BFS를 돌고나서도 0인곳이 없으면 -> true
		if (check() == false) System.out.println(time-1);
		else System.out.println(-1);
		}
	}

	private static void BFS() {
		time = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] current = q.poll();
				int cr = current[0];// 현재 행
				int cc = current[1];// 현재 열
				int ch = current[2];// 현재 층
				// 4방향 조사
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];

					if (rangeCheck(nr, nc)) {
						if (box[nr][nc][ch] == 0 && visit[nr][nc][ch] == false) {
							insertQueue(nr, nc, ch);
						}
					}
				}
				// 2방향 높낮이 조사
				for (int hir = 0; hir < 2; hir++) {
					int nh = ch + dh[hir];
					// 현재 위치의 위아래 조사
					if (rangeCheck(nh)) {
						if (box[cr][cc][nh] == 0 && visit[cr][cc][nh] == false) {
							insertQueue(cr, cc, nh);
						}
					}
				}

			}
			//System.out.println("BFS후");
			//view();
			time++;
		}

	}

	private static boolean check() {
		for (int height = 0; height < H; height++) {
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					//0이 -> 모든 토마토가 익어있는 상태
					if (box[row][col][height] == 0)
						return true;
				}
			}
		}
		return false;
	}
	
	private static boolean rangeCheck(int nh) {
		if (nh >= 0 && nh < H)
			return true;
		return false;
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}

	private static void insertQueue(int row, int col, int height) {
		q.add(new int[] { row, col, height });
		visit[row][col][height] = true;
		box[row][col][height] = 1;
	}
}
