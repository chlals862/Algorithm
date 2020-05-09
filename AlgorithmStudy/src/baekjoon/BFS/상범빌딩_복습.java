package baekjoon.BFS;

/*3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

1 3 3
S##
#E#
###

0 0 0*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상범빌딩_복습 {
	static int H, R, C;
	static int time;
	static boolean flag;
	static char[][][] map;
	static boolean[][][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dh = { -1, 1 };
	static Queue<int[]> q = new LinkedList<int[]>();

	public static void main(String[] args) {

		inputData();
	}

	private static void BFS() {
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int currentR = currentRC[0];
				int currentC = currentRC[1];
				int currentH = currentRC[2];

				// 종료조건
				if (map[currentR][currentC][currentH] == 'E') {
					flag = true;
					return;
				}

				for (int dir = 0; dir < 4; dir++) {
					int nr = currentR + dr[dir];
					int nc = currentC + dc[dir];
					// 현재층 조사
					if (rangeCheck(nr, nc)) {
						if (map[nr][nc][currentH] != '#' && visit[nr][nc][currentH] == false) {
							q.add(new int[] { nr, nc, currentH });
							visit[nr][nc][currentH] = true;
						}
					}

				}
				// 위 아래층 조사
				for (int dir = 0; dir < 2; dir++) {
					int h = currentH + dh[dir];

					if (rangeCheck(h)) {
						if (map[currentR][currentC][h] != '#' && visit[currentR][currentC][h] == false) {
							q.add(new int[] { currentR, currentC, h });
							visit[currentR][currentC][h] = true;
						}
					}
				}
			}
			time++;
		}

	}

	private static boolean rangeCheck(int h) {
		if (h >= 0 && h < H)
			return true;
		return false;
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}

	private static void inputData() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			//초기화
			q.clear();
			flag = false;
			time = 0;
			//입력
			H = sc.nextInt(); // 층
			R = sc.nextInt(); // 행
			C = sc.nextInt(); // 열
			sc.nextLine();
			if(H == 0 && R == 0 && C == 0) {
				return;
			}
			
			map = new char[R][C][H];
			visit = new boolean[R][C][H];

			for (int h = 0; h < H; h++) {
				for (int row = 0; row < R; row++) {
					String sLine = sc.nextLine();
					for (int col = 0; col < C; col++) {
						map[row][col][h] = sLine.charAt(col);
					}
				}
				sc.nextLine();
			}

			for (int h = 0; h < H; h++) {
				for (int row = 0; row < R; row++) {
					for (int col = 0; col < C; col++) {
						if (map[row][col][h] == 'S') {
							q.add(new int[] { row, col, h });
							visit[row][col][h] = true;
						}
					}
				}
				
			}
			BFS();
			if(flag == true) {
				System.out.println("Escaped in" + " " + time+" minute(s).");
			}else if(flag == false) {
				System.out.println("Trapped!");
			}
			
		}
	}

	
}
