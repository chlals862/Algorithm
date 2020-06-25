package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 빙산 {

	static int R, C;
	static int[][] sea;
	static int[][] countZeroMap;
	static boolean divide;
	static int year;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> q = new LinkedList<int[]>();
	static boolean[][] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		sea = new int[R][C];

		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				sea[row][col] = sc.nextInt();
			}
		}

		simulation();
		if(divide) System.out.println(year);
		else System.out.println(0);
	}

	private static void simulation() {
		// 언제 끝날지 모르니까
		divide = true;
		while (true) {
			if (divideCheck() == true) { //BFS로 빙산 덩어리조사
				return; //else if 걸릴때 
			}
			setCountZeroMap(); //빙산에 인접한 0의 개수 처리
			melt(); //인접한 0의 개수로 빙산 녹이기
			//얼음이 없으면
			if(existIce()) { //빙산이 다 녹고 바다냐
				divide = false;
				return;
			}
			year++;
		}

	}

	private static boolean existIce() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(sea[row][col] > 0 ) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean divideCheck() {
		q.clear();// 초기화
		visit = new boolean[R][C];
		int mass = 0; //덩어리
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if(visit[row][col] == false && sea[row][col] > 0 && mass == 0) {
					mass++;
					insertQueue(row,col);
					BFS();
				}else if(visit[row][col] == false && sea[row][col] > 0 && mass == 1) {
					return true;
				}
			}
		}
		return false;
	}



	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentIce = q.poll();
				int cr = currentIce[0];
				int cc = currentIce[1];
				
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(rangeCheck(nr,nc)) { //영역 만족
						//인접해 있는 빙산들 전부 칠하기
						if(sea[nr][nc] > 0 && visit[nr][nc] == false) {
							insertQueue(nr, nc);
						}
					}
				}
				
			}
			view();
		}
		
	}

	private static void view() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(sea[row][col]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void insertQueue(int row, int col) {
		q.add(new int[] {row,col});
		visit[row][col] = true;
	}

	private static void melt() {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				sea[row][col] -= countZeroMap[row][col];
				if (sea[row][col] < 0) {
					sea[row][col] = 0;
				}

			}
		}

	}

	private static void setCountZeroMap() {
		countZeroMap = new int[R][C];

		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (sea[row][col] > 0) {
					int count = 0;
					for (int dir = 0; dir < 4; dir++) {
						int nr = row + dr[dir];
						int nc = col + dc[dir];

						if (rangeCheck(nr, nc)) {
							if (sea[nr][nc] == 0) {
								count++;
							}
						}
						countZeroMap[row][col] = count;
					}

				}
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
