package baekjoon.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동 {
	static int N,L,R,moveCount;
	static int map[][];
	static boolean visit[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static ArrayList<Integer> tempList;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//행,열
		L = sc.nextInt();//인접한 국가의 최소값
		R = sc.nextInt();//인정합 국가의 최대값
		
		map = new int[N][N];
		visit = new boolean[N][N];
		moveCount = 0;
		
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				map[row][col] = sc.nextInt();
			System.out.println("행 = " + row + " 열 = " + col);
				q.add(new int[] {row,col});
			}
		}
		
		BFS();
		
		
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			System.out.println("size = " + size);
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int currentR = currentRC[0];
				int currentC = currentRC[1];
				
				for(int dir = 0; dir<4; dir++) {
					int nr = currentR + dr[dir];
					int nc = currentC + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						if(visit[nr][nc] == false) {
							map[nr][nc] = 1;
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			view();
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= N-1 && nc >= 0 && nc <= N-1) {
			return true;
		}
		return false;
	}
	private static void view() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	private static void view2() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
