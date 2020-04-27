package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이_복습 {
	static int W,H,time;//가로 W , 세로 H
	static int[][] map;
	static boolean[][][] visit;
	static boolean flag;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] hr = {-2,-1,1,2,2,1,-1,-2};
	static int[] hc = {1,2,2,1,-1,-2,-2,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		 W = sc.nextInt();
		 H = sc.nextInt();
		time = 0;
		map = new int[H][W];
		visit = new boolean[H][W][31];
		for(int row=0;row<H;row++) {
			for(int col=0;col<W;col++) {
				map[row][col] = sc.nextInt();
			}
		}
		//원숭이 시작점은 0,0
		//방문한곳은 다시 방문하지 않음
		q.add(new int[] {0,0,K});
		visit[0][0][K] = true;
		BFS();
		
		if(flag == true) {
			System.out.println(time);
		}else {
			System.out.println(-1);
		}
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] current = q.poll();
				
				//current 0은 row,1은 col, 능력치도 가지고 오자
				int currentRow = current[0];
				int currentCol = current[1];
				int currentAbility = current[2];
				
				//종료시점
				if(currentRow == H-1 && currentCol == W-1) {
					flag = true;
					return;
				}
				//4방향
				for(int dir=0;dir<4;dir++) {
					int nr = currentRow + dr[dir];
					int nc = currentCol + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] != 1 && visit[nr][nc][currentAbility] == false) {
							q.add(new int[] {nr,nc,currentAbility});
							visit[nr][nc][currentAbility] = true;
						}
					}
				}
			if(currentAbility != 0) {
				for(int hir=0;hir<8;hir++) {
					int nr = currentRow + hr[hir];
					int nc = currentCol + hc[hir];
					
					if(rangeCheck(nr,nc)) {
														//능력치를 썼을떄의 위치
						if(map[nr][nc] != 1 && visit[nr][nc][currentAbility-1] == false) {
							q.add(new int[] {nr,nc,currentAbility-1});
							visit[nr][nc][currentAbility-1] = true;
						}
					}
				}
			}
			
		}
			time++;
	}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= H-1 && nc >= 0 && nc <= W-1) {
			return true;
		}
		return false;
	}
}
