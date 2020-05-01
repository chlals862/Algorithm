package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 적록색약 {
	static int N;
	static int yRGB, nRGB;
	static char[][][] map;
	static boolean[][][] visit;
	static Queue<Position> q;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Position {
		int row;
		int col;
		int isRgb;

		public Position(int row, int col, int isRgb) {
			this.row = row;
			this.col = col;
			this.isRgb = isRgb;
		}
	}
	// map[0][row][col] => 적록색약 적용X 44
	// map[1][row][col] => 적록색약 적용O 33
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 행 열
		map = new char[2][N][N];
		visit = new boolean[2][N][N];
		q = new LinkedList<Position>();
		
		for (int row = 0; row < N; row++) {
			String sLine = sc.next();
			for (int col = 0; col < N; col++) {
				map[0][row][col] = sLine.charAt(col);
				map[1][row][col] = sLine.charAt(col);
				//적록색약 적용
				if (map[1][row][col] == 'G') {
					map[1][row][col] = 'R';
				}
			}
		}

		for (int k = 0; k < 2; k++) {
			visit = new boolean[2][N][N];
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					char color = map[k][row][col];

					if (visit[k][row][col] == false) {
						//적록색약 적용X  R , G , B
						if (k == 0)
							yRGB++;
						//적록색약 적용O  R = G , B
						else if (k == 1) 
							nRGB++;
						
						q.add(new Position(row, col, k));
						BFS(color);
					}
				}
			}
		}
		System.out.println(yRGB + " " + nRGB);
	}

	private static void BFS(char color) {
		while (!q.isEmpty()) {
			//System.out.println("color = " + color);
			//System.out.println("BFS전");
			//view();
			
			Position pos = q.poll();
			visit[pos.isRgb][pos.row][pos.col] = true;
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = pos.row + dr[dir];
				int nc = pos.col + dc[dir];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[pos.isRgb][nr][nc] != color || visit[pos.isRgb][nr][nc] == true) continue;
				
				visit[pos.isRgb][nr][nc] = true;
				q.add(new Position(nr, nc, pos.isRgb));
			}
		//System.out.println("BFS후");
		//	view();
		}
	}
	private static void view() {
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(visit[k][i][j]);
				}

				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}
}
