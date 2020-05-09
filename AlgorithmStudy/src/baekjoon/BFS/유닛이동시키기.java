package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*5 5 2 2 5
2 2 
3 2
3 3 
4 3
5 3
4 1
1 4*/


public class 유닛이동시키기 {
	static int time;
	static int R,C,A,B,K;
	static int startW,endW;
	static int SR,SC,RR,RC;
	static int[][] map;
	static int[][] unit;
	static boolean[][] visit;
	static boolean flag;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		
		inputData();
	}

	private static void inputData() {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt(); //행
		C = sc.nextInt(); //열
		A = sc.nextInt(); //유닛세로 크기
		B = sc.nextInt(); //유닛가로 크기
		K = sc.nextInt(); //장애물 개수
		
		map = new int[R][C];
		visit = new boolean[R][C];
		unit = new int[A][B];
		//2,2 3,2 3,3 장애물
		for(int wall=0;wall<K;wall++) {
			startW = sc.nextInt();
			endW = sc.nextInt();
			map[startW-1][endW-1] = 1;
			visit[startW-1][endW-1] = true; 
		}
		
		SR = sc.nextInt(); //출발지 행
		SC = sc.nextInt(); //출발지 열
		RR = sc.nextInt(); //도착지 행
		RC = sc.nextInt(); //도착지 열
		
		q.add(new int[] {SR-1,SC-1});
		visit[SR-1][SC-1] = true;
		//view();
		time = 0;
		BFS();
		
		if(flag == true) {
			System.out.println(time);
		}else if(flag == false) {
			System.out.println(-1);
		}
	}

	private static void BFS() {
		while(!q.isEmpty()) {
			
			int size = q.size();

			for(int i=0; i<size;i++) {
				int[] currentRC = q.poll();
				int currentR = currentRC[0];
				int currentC = currentRC[1];
				//System.out.println("currentR = " + currentR + " currentC = " + currentC );
				if(currentR == RR-1 && currentC == RC-1) {
					flag = true;
					return;
				}
				
				for(int dir=0;dir<4;dir++) {
					int nr = currentR + dr[dir];
					int nc = currentC + dc[dir];
					
					if(rangeCheck(nr,nc) && rangeWall(nr,nc)) {
						if(visit[nr][nc] == false) {
							map[nr][nc] = 2;
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}

			//view();
			time++;
		}
		
	}

	private static boolean rangeWall(int nr, int nc) {
		if(nr+A-1 < R && nc+B-1 <C) {
			for(int i=nr;i<=nr+A-1; i++) {
				for(int j=nc;j<=nc+B-1; j++) {
					if(map[i][j] == 1) return false;
				}
			}
		}else return false;
		return true;
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C ) return true;
			return false;
	}

	private static void view() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	private static void booleanview() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
