package baekjoon.DFS;

import java.util.Scanner;

public class 미로탐색 {
	static int R,C;
	static char[][] maze;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		maze = new char[R][C];
		visit = new boolean[R][C];
		
		for(int row=0;row<R;row++) {
			String sLine = sc.nextLine();
			maze[row] = sLine.toCharArray();
		}

		visit[0][0] = true;
		DFS(0,0,1);
		System.out.println(answer);
	}
	private static void DFS(int currentR, int currentC, int depth) {
		if(currentR == R-1 && currentC == C-1) {
			//종료하는 시점에 액션
			answer = Math.min(depth, answer);
			return;
		}
		for(int dir=0;dir<4;dir++) {
			int nr = currentR + dr[dir];
			int nc = currentC + dc[dir];
			
			if(rangeCheck(nr,nc)) {
				if(maze[nr][nc] == '1' && visit[nr][nc] == false) {
					visit[nr][nc] = true;
					DFS(nr,nc,depth+1);
					visit[nr][nc] = false;
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
}
