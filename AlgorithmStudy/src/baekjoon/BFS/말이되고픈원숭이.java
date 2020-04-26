package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이 {
	static int W, H; // 너비,높이
	static int count;
	static int[][] zoo;
	static boolean[][][] visit;
	static boolean flag;
	// 4방향 && 8방향
	static int[] dr = { -1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1 };
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 능력 -> 지역변수 . . . . . . . . .. . . .
		W = sc.nextInt(); // 너비
		H = sc.nextInt(); // 높이
		zoo = new int[H][W];
		visit = new boolean[H][W][31];
		count = 0;
		for (int row = 0; row < H; row++) {
			for (int col = 0; col < W; col++) {
				zoo[row][col] = sc.nextInt();
			}
		}
		// 원숭이새끼 시작점
		// 분신이 분신을 낳고 그 분신이 분신을 ...8방향,4방향 다 조사
		q.add(new int[] { 0, 0, K });
		visit[0][0][K] = true;
		//zoo[0][0]=2;
		//view();

		BFS();
		if(flag == true) {
		System.out.println(count);
		}else {
			System.out.println(-1);
		}
	}

	private static void BFS() {
		while (!q.isEmpty()) {
//			System.out.println("움직이기전");
//			view();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] current = q.poll();
				int currentR = current[0];
				int currentC = current[1];
				int currentAbility = current[2];
				if(currentR == H-1 && currentC == W-1) {
					flag = true;
					return;
				}
				for (int dir = 0; dir < 4; dir++) {
					int nr = currentR + dr[dir];
					int nc = currentC + dc[dir];

					if (rangeCheck(nr, nc) && zoo[nr][nc] != 1 && visit[nr][nc][currentAbility] == false) {
						//zoo[nr][nc]=2;
						q.add(new int[] { nr, nc, currentAbility });
						visit[nr][nc][currentAbility] = true;
					}
				}
				if (currentAbility > 0) {
					for (int hir = 4; hir < 12; hir++) {
						int nr = currentR + dr[hir];
						int nc = currentC + dc[hir];
						
						if (rangeCheck(nr, nc) && zoo[nr][nc] != 1 && visit[nr][nc][currentAbility-1] == false) {
							//zoo[nr][nc]=2;
							q.add(new int[] {nr,nc,currentAbility-1});
							visit[nr][nc][currentAbility-1] = true;
						}
					}
					
				}

			}
//			System.out.println("움직인 후");
//			view();
			count++;
		}

	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr <= H - 1 && nc >= 0 && nc <= W - 1) {
			return true;
		}
		return false;
	}

	private static void view() {
		for (int row = 0; row < H; row++) {
			for (int col = 0; col < W; col++) {
				System.out.print(zoo[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
