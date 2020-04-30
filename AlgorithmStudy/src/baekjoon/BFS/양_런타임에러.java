package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 양_런타임에러 {
	static int R, C;
	static int sheep, wolf;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static Queue<int[]> wList;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();

		map = new char[R][C];
		visit = new boolean[R][C];
		q = new LinkedList<int[]>();
		wList = new LinkedList<int[]>();

		for (int row = 0; row < R; row++) {
			String sline = sc.nextLine();
			map[row] = sline.toCharArray();
			for (int col = 0; col < C; col++) {
				if (map[row][col] == 'o') {
					sheep++;
				} else if (map[row][col] == 'v') {
					wList.add(new int[] { row, col });
					wolf++;
				}
			}
		}
		
		int size = wList.size();
		for (int i = 0; i < size; i++) {
			int[] current = wList.poll();
			if (visit[current[0]][current[1]] == false) {
				visit[current[0]][current[1]] = true;
				q.add(new int[] { current[0], current[1] });
				BFS();
				
			}
		}
		System.out.println(sheep + " " + wolf);
	}

	private static void BFS() {
		int w = 1, s = 0;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = current[0] + dr[dir];
				int nc = current[1] + dc[dir];
				if (map[nr][nc] == '#' || visit[nr][nc] == true) {
					continue;
				}

				if (map[nr][nc] == 'o') {
					s++;
				} else if (map[nr][nc] == 'v') {
					w++;
				}
				q.add(new int[] { nr, nc });
				visit[nr][nc] = true;
			}
		}
		if (w >= s) {
			sheep -= s;
		} else if (w < s) {
			wolf -= w;
		}
	}
//	private static void view() {
//		for(int row=0;row<R;row++) {
//			for(int col=0;col<C;col++) {
//				System.out.print(visit[row][col] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
