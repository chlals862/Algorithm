package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이_미완 {
	static int K, M, N;
	static char[][] map;
	static boolean[][] visitMap;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dr2 = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc2 = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int nr, nc, hr, hc, count;
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();// 능력 수
		M = sc.nextInt();// 열
		N = sc.nextInt();// 행

		map = new char[N][M];
		visitMap = new boolean[N][M];

		sc.nextLine();
		for (int row = 0; row < N; row++) {
			String sLine = sc.nextLine();
			map[row] = sLine.toCharArray();
		}

		count = 0;
		q.add(new int[] { 0, 0, K });
		visitMap[0][0] = true;

		BFS();
		System.out.println("count = " + count);
	}

	private static void BFS() {

		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
			if(K!=0) {
				for (int hir = 0; hir < 8; hir++) {
					hr = currentRC[0] + dr2[hir];
					hc = currentRC[1] + dc2[hir];
					
					if (rangeCheck2(hr, hc) && visitMap[hr][hc] == false && K != 1) {
						K--;
						if (hr == N - 1 && hc == M - 1) {
							System.out.println("end1");
							return;
						}
						q.add(new int[] { hr, hc, K });
						visitMap[hr][hc] = true;
						count++;
					}
					
				}
			}
			if(K==0) {
				for (int dir = 0; dir < 4; dir++) {
					nr = currentRC[0] + dr[dir];
					nc = currentRC[1] + dc[dir];
					System.out.println("1");
					if (rangeCheck1(nr, nc) && visitMap[nr][nc] == false) {
						System.out.println("2");
						if (nr == N - 1 && nc == M - 1) {
							System.out.println("end2");
							return;
						}
						q.add(new int[] { nr, nc, K });
						visitMap[nr][nc] = true;
							count++;
						}

					}
				}
			}
		}
	}

	private static boolean rangeCheck2(int hr, int hc) {
		if (hr >= 0 && hr <= N - 1 && hc >= 0 && hc <= M - 1) {
			return true;
		}
		return false;

	}

	private static boolean rangeCheck1(int nr, int nc) {
		if (nr >= 0 && nr <= N - 1 && nc >= 0 && nc <= M - 1) {
			return true;
		}
		return false;
	}
//	private static void view() {
//		 for(int row=0;row<N;row++) {
//			 //for(int col=0;col<M;col++) {
//				 System.out.print(map[row]);
//			 //}
//			 System.out.println();
//		 }
//		 System.out.println();
//		
//	}
}
