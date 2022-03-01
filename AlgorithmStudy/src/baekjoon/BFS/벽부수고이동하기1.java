package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기1 {
	static int R, C;
	static int time;
	static boolean flag;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][][] visit;
	static Queue<int[]> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = 1; // 벽을 부술수 있는 횟수
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		visit = new boolean[R][C][2];

		for (int row = 0; row < R; row++) {
			String sline = sc.nextLine();
			map[row] = sline.toCharArray();
		}
		q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0, A });
		visit[0][0][A] = true;
		BFS();	
		if(flag == true) {
			System.out.println(time+1);
		}else {
			System.out.println(-1);
		}
	}
	private static void BFS() {
		while (!q.isEmpty()) {
			int size = q.size();
//			System.out.println("BFS전");
//			view();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int currentR = currentRC[0];
				int currentC = currentRC[1];
				int currentAbility = currentRC[2];

				if (currentR == R - 1 && currentC == C - 1) {
					flag = true;
					return;
				}
				for (int dir = 0; dir < 4; dir++) {
					int nr = currentR + dr[dir];
					int nc = currentC + dc[dir];

					if (rangeCheck(nr, nc)) {
						if (map[nr][nc] == '0' && visit[nr][nc][currentAbility] == false && map[nr][nc] != '1') {
							q.add(new int[] { nr, nc, currentAbility });
							visit[nr][nc][currentAbility] = true;
						}
					}
					if (currentAbility > 0) {
				

							if (rangeCheck(nr, nc)) {
								if (map[nr][nc] == '0'
										|| map[nr][nc] == '1' && visit[nr][nc][currentAbility - 1] == false) {
									map[nr][nc] = '0';
									q.add(new int[] { nr, nc, currentAbility - 1 });
									visit[nr][nc][currentAbility - 1] = true;
									
								}
							
						}
					}
				}
			}
//			System.out.println("BFS후");
//			view();
			time++;
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr <= R - 1 && nc >= 0 && nc <= C - 1) {
			return true;
		}
		return false;
	}
//	private static void view() {
//		for(int row=0;row<R;row++) {
//			for(int col=0;col<C;col++) {
//				System.out.print(map[row][col] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
