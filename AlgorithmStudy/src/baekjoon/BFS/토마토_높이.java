package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_높이 {
	static int R, C, H;
	static int day;
	static int[][][] box;
	static boolean[][][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] dh = {-1,1};
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		C = sc.nextInt();
		R = sc.nextInt();
		H = sc.nextInt();
		
		box = new int[R][C][H];
		visit = new boolean[R][C][H];
		
		for (int h = 0; h < H; h++) {
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					box[row][col][h] = sc.nextInt();
					if(box[row][col][h] == 1) {
						insertQueue(row,col,h);
					}
				}
			}
		}
		if(endCheck() == true) {
			System.out.println("0");
		}else {
			BFS();
			if(endCheck()) System.out.println(day-1);
			else System.out.println("-1");
		}
		
		
		
	}
	private static void BFS() {
		day = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentTomato = q.poll();
				int cr = currentTomato[0];
				int cc = currentTomato[1];
				int ch = currentTomato[2];
				
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						//현재층에서의 4방향
						if(visit[nr][nc][ch]==false && box[nr][nc][ch] == 0) {
							insertQueue(nr, nc, ch);
						}
					}
				}
				for(int dir=0;dir<2;dir++) {
					int nh = ch + dh[dir];
					if(heightCheck(nh)) {
						//현재 칸에서 위아래 층
						if(visit[cr][cc][nh] == false && box[cr][cc][nh] == 0) {
							insertQueue(cr, cc, nh);
						}
					}
				}
			}
			day++;
		}
		
	}
	private static boolean heightCheck(int nh) {
		if(nh >= 0 && nh < H) return true;
		return false;
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
	private static boolean endCheck() {
		for(int h=0;h<H;h++) {
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(box[row][col][h] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	private static void insertQueue(int row, int col, int h) {
		q.add(new int[] {row,col,h});
		visit[row][col][h]  = true;
		box[row][col][h] = 1;
	}
}
