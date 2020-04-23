package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동 {
	static int inputNum;
	static int[][] map;
	static boolean[][] visitMap;
	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int count;
	static int side;
	static int endR;
	static int endC;
	static Queue<int[]> que = new LinkedList<int[]>();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		inputNum = sc.nextInt();

		for (int testCase = 0; testCase < inputNum; testCase++) {
			que.clear();
			count = 0;
			side = sc.nextInt();// 변 N*M
			int startR = sc.nextInt(); // 시작 행
			int startC = sc.nextInt();// 시작 열
			endR = sc.nextInt();// 종료 행
			endC = sc.nextInt();// 종료 열
			
			map = new int[side][side];
			visitMap = new boolean[side][side];
			
			que.add(new int[] { startR, startC });
			visitMap[startR][startC] = true;
			
			BFS();
			
			if (startR == endR && startC == endC) {
				System.out.println(0);
			} else
				System.out.println(count);
		}
	}
	private static void BFS() {

		while (!que.isEmpty()) {
			count++;
			int size = que.size();     
			 
			for (int i = 0; i < size; i++) {
				int[] currentRC = que.poll();

				for (int dir = 0; dir < 8; dir++) {
					int nr = currentRC[0] + dr[dir];
					int nc = currentRC[1] + dc[dir];

					if (rangeCheck(nr, nc) && visitMap[nr][nc] == false) {
						if (nr == endR && nc == endC) {
							return;
						}
						que.add(new int[] { nr, nc });
						visitMap[nr][nc] = true;
					}
				}
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr <= side - 1 && nc >= 0 && nc <= side - 1) {
			return true;
		}
		return false;
	}
}
