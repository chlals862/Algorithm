package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 데스나이트 {
	static int N,startR,startC,endR,endC,cnt;
	static int[][] map;
	static boolean[][] visit;
	static boolean flag;
	static int[] dr = {-2,-2,0,0,2,2};
	static int[] dc = {-1,1,-2,2,-1,1};
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		startR = sc.nextInt();
		startC = sc.nextInt();
		endR = sc.nextInt();
		endC = sc.nextInt();
		cnt = 0;
		map = new int[N][N];
		visit = new boolean[N][N];
		logic();
	}

	private static void logic() {
		map[startR][startC] = 1;
		q.add(new int[] {startR,startC});
		visit[startR][startC] = true;
		bfs();
		
		if(flag) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(cr == endR && cc == endC) {
					flag = true;
					return;
				}	
				for(int dir=0;dir<6;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == 0 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			cnt++;
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
			return false;
	}
}
