package baekjoon.BFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추 {
	static final int num = 1;
	static int area;
	static int N;
	static int M;
	static int K;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int targetR;
	static int targetC;
	static int[][] map;
	static boolean[][] visitMap;
	static ArrayList<Integer> answerlist;
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int testCase = 0; testCase < T; testCase++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][M];
			visitMap = new boolean[N][M];
			answerlist = new ArrayList<Integer>();
			for (int testCase2 = 0; testCase2 < K; testCase2++) {
				targetC = sc.nextInt();
				targetR = sc.nextInt();

				map[targetR][targetC] = num;
				 //view();
			}

			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {

					if (map[row][col] == num && visitMap[row][col] == false) {
						q.clear();
						q.add(new int[] { row, col });
						visitMap[row][col] = true;
						area = 1;
						BFS();
						answerlist.add(area);
					}
				}
			}
			System.out.println(answerlist.size());
		}
	}

	private static void BFS() {

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();

				for (int dir = 0; dir < 4; dir++) {
					int nr = currentRC[0] + dr[dir];
					int nc = currentRC[1] + dc[dir];

					if (rangeCheck(nr, nc) && visitMap[nr][nc] == false && map[nr][nc] == num) {
						q.add(new int[] { nr, nc });
						visitMap[nr][nc] = true;

					}
				}
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr <= N - 1 && nc >= 0 && nc <= M - 1) {
			return true;
		}
		return false;
	}
//	private static void view() {
//		for(int row=0;row<N;row++) {
//			for(int col=0;col<M;col++) {
//				System.out.print(map[row][col] + "");
//				
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//	}
}
